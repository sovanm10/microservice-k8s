FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/customer-service-k8s-example-0.0.1-SNAPSHOT.jar customer-service-k8s-example-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /customer-service-k8s-example-0.0.1-SNAPSHOT.jar