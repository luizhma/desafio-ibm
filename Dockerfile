FROM adoptopenjdk/openjdk11:alpine
MAINTAINER Jair Rillo <jairrj@br.ibm.com>

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY target/*.jar ./app.jar
ENTRYPOINT ["java","-jar","/app.jar"]