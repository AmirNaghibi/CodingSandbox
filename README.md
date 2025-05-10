# Java Sandbox Environment

A Docker-based Java development environment for experimenting with Java standard library and third-party libraries. This sandbox comes pre-configured with:

- Java 17 (Eclipse Temurin)
- Gradle for dependency management
- Popular libraries:
  - OkHttp for HTTP requests
  - Jackson for JSON processing
  - Lombok for reducing boilerplate
  - JUnit for testing

## Getting Started

1. Build the Docker image:
```bash
docker build -t java-sandbox .
```

2. Run the container:
```bash
docker run -d --name java-sandbox -v $(pwd):/app java-sandbox
```

3. Execute Java code inside the container:
```bash
docker exec -it java-sandbox gradle run
```

## Development Workflow

1. Write your Java code in the `src/main/java/com/sandbox` directory
2. Add any new dependencies to `build.gradle`
3. Rebuild the container if you modify the `build.gradle`
4. Use the provided `HttpExample.java` as a template for your experiments

## Example Code

The project includes a sample `HttpExample.java` that demonstrates:
- Making HTTP GET requests
- Making HTTP POST requests with JSON body
- Using OkHttp client
- Basic error handling

## Tips

- The container stays running, so you can execute multiple commands
- Use `docker exec -it java-sandbox /bin/bash` to get a shell inside the container
- Add new dependencies in `build.gradle` as needed
- Use `gradle clean` to clean the build directory
- Use `gradle build` to compile and run tests
- Use `gradle dependencies` to view the dependency tree 