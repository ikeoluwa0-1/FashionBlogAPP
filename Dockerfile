#FROM openjdk:17
#EXPOSE 8080
#ADD target/week-ten-task.jar week-ten-task.jar
#ENTRYPOINT["java", "-jar", "/week-ten-task.jar"]

FROM eclipse-temurin:17-jre-alpine
#RUN mkdir -p /ctk
ADD target/week-ten-task.jar week-ten-task.jar
#WORKDIR /ctk
ENTRYPOINT ["java" ,"-jar", "week-ten-task.jar"]