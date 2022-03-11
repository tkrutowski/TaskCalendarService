FROM adoptopenjdk/openjdk11:jdk-11.0.2.7-alpine-slim
COPY java.security /opt/java/openjdk/conf/security
COPY target/taskcalendar-service-0.0.2-exec.jar .
EXPOSE 8088
CMD java -jar taskcalendar-service-0.0.2-exec.jar