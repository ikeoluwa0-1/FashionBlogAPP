FROM openjdk:17
EXPOSE 8080
ADD target/week-ten-task.jar week-ten-task.jar
ENTRYPOINT["java", "-jar", "/weekclear-ten-task.jar"]