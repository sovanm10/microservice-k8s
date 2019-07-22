FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/order-service-0.0.1-SNAPSHOT.jar order-service-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /order-service-0.0.1-SNAPSHOT.jar