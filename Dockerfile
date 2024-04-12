FROM openjdk:8-jdk
ENV APP_JAR_NAME flyio
RUN mkdir /app
ADD ./target/dev-project-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-kDuser.timezone=Asia/Saigon", "-jar", "dev-project-0.0.1-SNAPSHOT.jar"]