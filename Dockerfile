# Utiliser une image Java pour exécuter l'application
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY target/*.jar app.jar

# Exposer le port 8081 pour correspondre à la configuration de `server.port`
EXPOSE 8081

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
