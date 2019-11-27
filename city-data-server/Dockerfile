FROM openjdk:8-jre-alpine
COPY target/city-data-server.jar /city-data-server.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /city-data-server.jar
