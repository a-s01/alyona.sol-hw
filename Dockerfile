FROM openjdk:8-jre-alpine
LABEL org.opencontainers.image.authors="olena_solodiankina@epam.com"

COPY ["target/EpamLab-2021-1.0-SNAPSHOT.jar", "library-app.jar"]
EXPOSE 8080
EXPOSE 9090

ENTRYPOINT ["java", "-jar", "library-app.jar"]
