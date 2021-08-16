FROM tomcat:8.5.47-jdk11-openjdk
WORKDIR devops
COPY ./target/devops.jar .
ENTRYPOINT ["java", "-jar", "devops.jar"]