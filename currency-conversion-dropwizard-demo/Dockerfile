FROM maven:3.6.3-jdk-8-slim AS build
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/currency-conversion-dropwizard-demo/pom.xml clean package

FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY --from=build /home/app/currency-conversion-dropwizard-demo/target/*.jar DropWizardDemo-1.0-SNAPSHOT.jar 
ENTRYPOINT [ "sh", "-c", "java -jar DropWizardDemo-1.0-SNAPSHOT.jar server example.yml" ]
