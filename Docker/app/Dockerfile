FROM openjdk:15-jre-slim-sid
RUN useradd -r docker_tom -u 950

USER docker_tom
WORKDIR /usr/src/app
COPY target/ROOT.jar site.jar

EXPOSE 8080
EXPOSE 8081

ENV JAVA_OPTS "-Xms128m -Xmx1536m"

CMD ["java", "-Xms128m -Xmx1536m", "-jar", "/usr/src/app/site.jar"]