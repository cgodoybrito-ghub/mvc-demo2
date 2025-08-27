FROM eclipse-temurin:21-jdk-jammy
ARG JAR_FILE=target/mvc-demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENV JAVA_OPTS="-Xms128m -Xmx256m"
ENTRYPOINT ["java", "-jar", "app.jar"]