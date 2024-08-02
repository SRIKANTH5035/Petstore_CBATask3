Feature: Pet operations

  Scenario: Retrieve a pet by id
    Given I have the pet endpoint
    When I retrieve a pet with id 1
    Then the response code should be 200
    And the pet name should be "dog"
    And log the response

  Scenario: Create a new pet
    Given I have the pet endpoint
    When I create a pet with name "doggie" and id 10
    Then the response code should be 200
    And log the response

  Scenario: Update an existing pet
    Given I have the pet endpoint
    When I update the pet with id 10 and name "doggie_updated"
    Then the response code should be 200
    And log the response

  Scenario: Delete a pet
    Given I have the pet endpoint
    When I delete the pet with id 10
    Then the response code should be 200
    And the pet should be deleted successfully

  Scenario: Add an image to a pet
    Given I have the pet endpoint
    When I add an image to the pet with id 10
    Then the response code should be 200
    And log the response

  Scenario: Create a new pet store
    Given I have the pet endpoint
    When I create a new pet store with name "NewPetStore" and id 20
    Then the response code should be 200
    And log the response

  Scenario: Find pets by status
    Given I have the pet endpoint
    When I find pets with status "available"
    Then the response code should be 200
    And the response should contain at least one pet
    And log the response
