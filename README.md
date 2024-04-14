# Project Documentation

## Overview
This project is a Java-based web application built with Spring Boot. It handles operations related to hotel bookings, interacting with clients and hotels. The application is containerized and can be run using Docker.

## Directory Structure
- `src/main`: Contains the main source code of the application.
- `src/test`: Contains the test code for the application.
- `target`: Used to store all output of the build.
- `.mvn`: Contains Maven wrapper files.
- `.vscode`: Contains Visual Studio Code workspace settings.

## Key Components
- `BookingController`: This is a REST controller that handles HTTP requests related to bookings. It is mapped to the `/api/v1/bookings` URL path.
- `BookingService`: This is a service class that contains business logic related to bookings.
- `ClientService`: This is a service class that contains business logic related to clients.
- `HotelService`: This is a service class that contains business logic related to hotels.

## OpenAPI Specs
- Visit this [link](localhost:8080/swagger-ui.html) after running the server.

## Build and Run
The project uses Maven for dependency management and build automation. You can build and run the project using the following commands:

```bash
mvn clean install
mvn spring-boot:run
```

The application is also containerized using Docker. You can build and run the Docker image using the following commands:

```bash
docker build -t my-app .
docker run -p 8080:8080 my-app
```

## Testing
Unit tests are located in the `src/test` directory. You can run the tests using the following command:

```bash
mvn test
```

## IDE
The project is set up for use with Visual Studio Code. Workspace-specific settings are located in the `.vscode` directory.

## Further Help
For more detailed information, refer to the `HELP.md` file in the project root directory.
