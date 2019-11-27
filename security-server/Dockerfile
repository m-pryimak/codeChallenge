FROM openjdk:8-jre-alpine
COPY target/security-server.jar /security-server.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /security-server.jar
