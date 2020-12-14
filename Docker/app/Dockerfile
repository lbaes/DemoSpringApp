FROM openjdk:15
RUN useradd -r calc -u 950
USER calc

WORKDIR /usr/src/app
COPY ./target/calculator-0.0.1-SNAPSHOT.jar calc.jar

EXPOSE 8080
EXPOSE 8081

ENV JAVA_OPTS "-Xms128m -Xmx1536m"

CMD ["java", "-Xms128m -Xmx1536m", "-jar", "/usr/src/app/calc.jar"]