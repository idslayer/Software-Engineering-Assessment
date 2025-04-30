# Use OpenJDK 17 base image
FROM cimg/openjdk:17.0.6

# Set working directory
WORKDIR /app

# Copy project files into the container
COPY . .

RUN chmod +x mvnw && sed -i "s/\r$//" mvnw
RUN ./mvnw --version && ./mvnw package
CMD ["java", "-jar", "target/bemedia.jar"]
