FROM adoptopenjdk:11-jre-hotspot

VOLUME /tmp

# Add the application's jar file
ARG JAR_FILE=target/storex-1.0.jar

ADD ${JAR_FILE} storex-1.0.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "storex-1.0.jar"]

# Make port 8080 available outside this container
EXPOSE 8080