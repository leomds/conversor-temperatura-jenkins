# Imagem do Jenkins usada no trabalho: Jenkins LTS + JDK 17 + Maven + plugins necessarios
FROM jenkins/jenkins:lts-jdk17
USER root
RUN apt-get update && apt-get install -y --no-install-recommends maven \
    && rm -rf /var/lib/apt/lists/*
USER jenkins
RUN jenkins-plugin-cli --plugins \
    git github workflow-aggregator pipeline-stage-view \
    junit jacoco timestamper configuration-as-code
# Pula o assistente inicial; o usuario admin e criado pelo casc.yaml
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
ENV CASC_JENKINS_CONFIG=/usr/share/jenkins/ref/casc.yaml
COPY casc.yaml /usr/share/jenkins/ref/casc.yaml
