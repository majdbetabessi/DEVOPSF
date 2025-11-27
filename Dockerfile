FROM eclipse-temurin:17-jre-alpine

ADD target/tp-foyer-5.0.0.jar tp-foyer-5.0.0.jar

EXPOSE 8092

ENTRYPOINT ["java", "-jar", "tp-foyer-5.0.0.jar"]
