docker run -v "$(pwd)/jenkins_home":/var/jenkins_home -d -p 8080:8080 -p 50000:50000 jenkins-with-plugins
#docker run -d -p 8080:8080 -p 50000:50000 jenkins-with-plugins
