FROM openjdk:8-jre-alpine
COPY target/api-gateway-server.jar /api-gateway-server.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /api-gateway-server.jar
