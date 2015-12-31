docker run -v "$(pwd)/jobs":/var/jenkins_home/jobs -d -p 8080:8080 -p 50000:50000 jenkins-with-plugins
#docker run -d -p 8080:8080 -p 50000:50000 jenkins-with-plugins
