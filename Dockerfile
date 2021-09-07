FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD build/libs/marketing-preferences-0.0.1.jar marketing-preferences-0.0.1.jar
ENTRYPOINT ["java","-jar","/marketing-preferences-0.0.1.jar"]