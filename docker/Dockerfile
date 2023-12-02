FROM jenkins/jenkins:2.434

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
ENV CASC_JENKINS_CONFIG="/var/jenkins_home/casc_configs/"

RUN mkdir -p /var/jenkins_home/casc_configs/

COPY --chown=jenkins:jenkins init.groovy $JENKINS_HOME/init.groovy

COPY --chown=jenkins:jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt
