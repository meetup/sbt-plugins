PROJECT_DIR := $(dir $(abspath $(lastword $(MAKEFILE_LIST))))
TARGET_DIR=$(PROJECT_DIR)target

CI_BUILD_NUMBER ?= $(USER)-SNAPSHOT
CI_IVY_CACHE ?= $(HOME)/.ivy2
CI_SBT_CACHE ?= $(HOME)/.sbt
CI_WORKDIR ?= $(shell pwd)

VERSION ?= 0.3.$(CI_BUILD_NUMBER)

BUILDER_TAG = "meetup/sbt-builder:0.1.3"

GROUP_ID?="com.meetup"
ARTIFACT_ID?=sbt-plugins_2.10

# lists all available targets
list:
	@sh -c "$(MAKE) -p no_op__ | \
		awk -F':' '/^[a-zA-Z0-9][^\$$#\/\\t=]*:([^=]|$$)/ {split(\$$1,A,/ /);\
		for(i in A)print A[i]}' | \
		grep -v '__\$$' | \
		grep -v 'make\[1\]' | \
		grep -v 'Makefile' | \
		sort"

# required for list
no_op__:

clean:
	@sbt clean
	rm -rf $(TARGET_DIR)

package-sbt:
	sbt publishLocal

package:
	docker pull $(BUILDER_TAG)
	docker run \
		--rm \
		-v $(CI_WORKDIR):/data \
		-v $(CI_IVY_CACHE):/root/.ivy2 \
		-v $(CI_SBT_CACHE):/root/.sbt \
		-v /var/run/docker.sock:/var/run/docker.sock \
		-e VERSION=$(VERSION) \
		$(BUILDER_TAG) \
		make package-sbt

publish: package
	docker pull $(BUILDER_TAG)
	docker run \
		--rm \
		-v $(CI_WORKDIR):/data \
		-v $(CI_IVY_CACHE):/root/.ivy2 \
		-v $(CI_SBT_CACHE):/root/.sbt \
		-e VERSION=$(VERSION) \
		$(BUILDER_TAG) \
		make publish-sbt

publish-sbt:
	mvn deploy:deploy-file -DgroupId=${GROUP_ID} \
		-DartifactId=${ARTIFACT_ID} \
		-Dversion=${VERSION} \
		-Dfile=./target/scala-2.11/${ARTIFACT_ID}-${VERSION}.jar \
		-DpomFile=./target/scala-2.11/${ARTIFACT_ID}-${VERSION}.pom \
		-Djavadoc=./target/scala-2.11/${ARTIFACT_ID}-${VERSION}-javadoc.jar \
		-Dsources=./target/scala-2.11/${ARTIFACT_ID}-${VERSION}-sources.jar \
		-DrepositoryId=github \
		-Durl=https://maven.pkg.github.com/meetup/meetup-oss

version:
	@echo $(VERSION)
