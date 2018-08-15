FROM openjdk:8-jdk-alpine
LABEL maintainer="ritesh_ranjan@infosys.com"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/fdt_server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} fdt_server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/fdt_server.jar"]