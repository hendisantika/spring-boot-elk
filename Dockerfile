FROM adoptopenjdk/openjdk11:alpine-jre
LABEL maintainer="hendisantika@yahoo.co.id"
VOLUME /tmp
EXPOSE 8080
ADD target/spring-boot-elk-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
WORKDIR /usr/app

