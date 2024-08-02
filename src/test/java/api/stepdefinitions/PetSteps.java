package api.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class PetSteps {

    private static final Logger logger = LogManager.getLogger(PetSteps.class);
    private Response response;

    @Given("I have the pet endpoint")
    public void i_have_the_pet_endpoint() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @When("I retrieve a pet with id {int}")
    public void i_retrieve_a_pet_with_id(int id) {
        response = given().pathParam("petId", id)
                .when().get("/pet/{petId}")
                .then().extract().response();
    }

    @Then("the response code should be {int}")
    public void the_response_code_should_be(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the pet name should be {string}")
    public void the_pet_name_should_be(String name) {
        assertEquals(name, response.jsonPath().getString("name"));
    }

    @When("I create a pet with name {string} and id {int}")
    public void i_create_a_pet_with_name_and_id(String name, int id) {
        String requestBody = String.format("{\"id\": %d, \"name\": \"%s\", \"status\": \"available\"}", id, name);

        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when().post("/pet")
                .then().extract().response();
    }

    @When("I update the pet with id {int} and name {string}")
    public void i_update_the_pet_with_id_and_name(int id, String name) {
        String requestBody = String.format("{\"id\": %d, \"name\": \"%s\", \"status\": \"available\"}", id, name);

        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when().put("/pet")
                .then().extract().response();
    }

    @When("I delete the pet with id {int}")
    public void i_delete_the_pet_with_id(int id) {
        response = given()
                .pathParam("petId", id)
                .when().delete("/pet/{petId}")
                .then().extract().response();
    }

    @Then("the pet should be deleted successfully")
    public void the_pet_should_be_deleted_successfully() {
        assertEquals(200, response.getStatusCode());
    }

    @When("I add an image to the pet with id {int}")
    public void i_add_an_image_to_the_pet_with_id(int id) {
        // Load the image file from the project directory
        File imageFile = new File("src/test/resources/images/dog.png");

        response = given()
                .header("Content-Type", "multipart/form-data")
                .multiPart("file", imageFile)
                .when().post("/pet/{petId}/uploadImage", id)
                .then().extract().response();
    }

    @When("I create a new pet store with name {string} and id {int}")
    public void i_create_a_new_pet_store_with_name_and_id(String name, int id) {
        String requestBody = String.format("{\"id\": %d, \"name\": \"%s\", \"status\": \"available\"}", id, name);

        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when().post("/pet")
                .then().extract().response();
    }

    @When("I find pets with status {string}")
    public void i_find_pets_with_status(String status) {
        response = given()
                .queryParam("status", status)
                .when().get("/pet/findByStatus")
                .then().extract().response();
    }

    @Then("the response should contain at least one pet")
    public void the_response_should_contain_at_least_one_pet() {
        List<String> pets = response.jsonPath().getList("");
        assertFalse("The response should contain at least one pet", pets.isEmpty());
    }

    @Then("log the response")
    public void log_the_response() {
        logger.info("Response Body: " + response.getBody().asString());
    }
}
