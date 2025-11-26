FROM eclipse-temurin:17-jdk

ADD target/tp-foyer-5.0.0.jar tp-foyer-5.0.0.jar

EXPOSE 8092

ENTRYPOINT ["java", "-jar", "tp-foyer-5.0.0.jar"]