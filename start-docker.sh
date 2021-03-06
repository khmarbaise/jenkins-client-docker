docker run --name jenkins-for-testing \
  -v "$(pwd)/jobs":/var/jenkins_home/jobs \
  -d \
  -p 8080:8080 \
  -p 50000:50000 \
  --env JENKINS_SLAVE_AGENT_PORT=50000 \
  --env JENKINS_OPTS=--httpPort=8080 \
  jenkins-with-plugins
