FROM openjdk:17-slim
ADD ./target/file-management.jar file-management.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "file-management.jar"]