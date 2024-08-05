# Utiliza una imagen base de Java
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
COPY target/materiales-service-0.0.1-SNAPSHOT.jar materiales-service.jar

# Expone el puerto en el que correrá la aplicación
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "materiales-service.jar"]
