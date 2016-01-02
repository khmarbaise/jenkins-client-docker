Docker Configuration for Jenkins API Client
===========================================

This Dockerfile defines the configuration for integration tests
of the [Jenkins API client for Java][1].

The `plugin.txt` contains the list of plugins which will be installed
during the build of the image.
Those plugins are needed for the integration tests.

[1]: https://github.com/RisingOak/jenkins-client
