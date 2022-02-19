FROM adoptopenjdk:11-jre-hotspot

VOLUME /tmp

# Make port 8084 available outside this container
EXPOSE 8084

# Add the application's jar file
ARG JAR_FILE=target/storex-1.0.jar

ADD ${JAR_FILE} storex-1.0.jar

# Run the jar file
ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom", "-jar", "/storex-1.0.jar"]