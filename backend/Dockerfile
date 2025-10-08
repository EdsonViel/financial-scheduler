# Etapa de build
FROM gradle:7.6.0-jdk11 AS build
WORKDIR /app

# Copia o código-fonte e o gradle config
COPY . .

# Faz o build sem rodar testes
RUN gradle build -x test

# Etapa de execução
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
