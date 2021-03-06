FROM jenkins:1.625.3
MAINTAINER "docker@soebes.de"
COPY ./plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY ./config.xml /usr/share/jenkins/ref/config.xml
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/ref/plugins.txt
