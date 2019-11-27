FROM openjdk:8-jre-alpine
COPY target/path-analyzer-server.jar /path-analyzer-server.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /path-analyzer-server.jar
