# API Automation Framework

This is an API automation framework built using Maven, Cucumber, TestNG, Java, RestAssured, and Log4j. It tests various operations on the PET endpoint of the Swagger Petstore API.

## Project Structure

- `pom.xml`: Maven configuration file.
- `src/main/java/com/example/api/utils/LogUtil.java`: Utility for logging.
- `src/test/java/com/example/api/stepdefinitions/PetSteps.java`: Cucumber step definitions for API scenarios.
- `src/test/java/com/example/api/runners/TestRunner.java`: Cucumber TestNG runner.
- `src/test/resources/features/pet.feature`: Cucumber feature file with scenarios.
- `src/test/resources/log4j2.xml`: Log4j2 configuration file.
- `src/test/resources/images/dog.png`: Images file.

## Prerequisites

- JDK 11 or higher
- Maven 3.6 or higher

## Setup

1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd api-automation-framework
    ```

2. Install dependencies:
    ```sh
    mvn clean install
    ```

## Running Tests

To run the Cucumber tests, use the following Maven command:

```sh
mvn test
