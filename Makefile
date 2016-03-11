include build.properties

PROJECT_DIR := $(dir $(abspath $(lastword $(MAKEFILE_LIST))))
TARGET_DIR=$(PROJECT_DIR)target

CI_BUILD_NUMBER ?= $(USER)-snapshot
CI_IVY_CACHE ?= $(HOME)/.ivy2
CI_SBT_CACHE ?= $(HOME)/.sbt
CI_WORKDIR ?= $(shell pwd)

RELEASE_VERSION ?= $(CI_BUILD_NUMBER)

BUILDER_TAG = $(builderImage):$(builderVersion)

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

package-local:
	sbt publishLocal

package:
	docker pull $(BUILDER_TAG)
	docker run \
		--rm \
		-v $(CI_WORKDIR):/data \
		-v $(CI_IVY_CACHE):/root/.ivy2 \
		-v $(CI_SBT_CACHE):/root/.sbt \
		-e RELEASE_VERSION=$(RELEASE_VERSION) \
		-v /var/run/docker.sock:/var/run/docker.sock \
		$(BUILDER_TAG)

publish:
	# This should publish the snapshot to nexus.

release:
	# This should set concrete version of jar
	# then tag in repo.

version:
	@echo $(RELEASE_VERSION)

deploy:
	# this should publish concrete version to nexus.