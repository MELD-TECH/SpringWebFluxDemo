FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/DemoWebFlux.jar /app/DemoWebFlux.jar

#execute the application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","DemoWebFlux.jar"]