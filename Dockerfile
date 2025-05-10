FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy Gradle wrapper files
COPY gradle gradle/
COPY gradlew .
COPY gradlew.bat .

# Copy project files
COPY build.gradle settings.gradle ./
COPY src ./src

# Download dependencies using wrapper
RUN ./gradlew dependencies

# Keep container running
CMD ["tail", "-f", "/dev/null"] 