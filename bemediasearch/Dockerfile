# Use OpenJDK 11 base image
FROM adoptopenjdk/openjdk11:jdk-11.0.14.1_1-alpine-slim

# Set working directory
WORKDIR /app

# Copy project files into the container
COPY . .

RUN chmod +x mvnw && sed -i "s/\r$//" mvnw
RUN ./mvnw test
RUN ./mvnw --version && ./mvnw package
CMD ["java", "-jar", "target/bemediasearch-0.0.1-SNAPSHOT.jar"]
