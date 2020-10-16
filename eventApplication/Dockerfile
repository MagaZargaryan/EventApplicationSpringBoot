FROM openjdk:8
RUN \
  apt-get update && \
  apt-get install -y --no-install-recommends vim mc netcat-openbsd telnet bash postgresql-client
ADD target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar" , "/app.jar"]