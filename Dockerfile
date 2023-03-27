FROM openjdk:17
ARG PORT=8081
ENV PORT=$PORT
EXPOSE $PORT
WORKDIR /app
#COPY target/chars-inf-0.0.1-SNAPSHOT.jar ./chars.jar
ENTRYPOINT java -jar ./chars.jar