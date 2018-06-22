# Change Log
All notable changes to this project will
be documented in this file.

## [0.3.x]
### Added
- Exclude generated files from coverage report
- Hardened compiler settings for scalac. Specifically:
  * `-Yno-adapted-args` to prevent auto-tupling and friends
  * `-Ywarn-dead-code` to prevent dead code
  * `-Ywarn-numeric-widen` to require explicit conversion between numeric types
  * `-Xfatal-warnings` to cause warnings to fail compilation

## [0.2.x]
### Added
- Added extra support for coveralls in Travis.

## [0.1.x]
### Added
- Everything.
