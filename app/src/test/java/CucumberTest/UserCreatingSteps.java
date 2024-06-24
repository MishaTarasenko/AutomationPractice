package CucumberTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ukma.User;
import ukma.Validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCreatingSteps {
    private String name;
    private String email;
    private int age;
    private String creationResult;
    private User user;

    @Given("a user with email {string} and age {string}")
    public void a_user_with_email_and_age(String email, String age) {
        this.name = "Name";
        this.email = email;
        this.age = Integer.parseInt(age);
    }

    @When("I try to create the user")
    public void i_try_to_create_the_user() {
        if (!Validator.validateEmail(email)) {
            creationResult = "Invalid email address";
        } else if (age < 18) {
            creationResult = "User must be at least 18 years old";
        } else {
            user = User.create(name, Integer.valueOf(age), email);
            creationResult = "Success";
        }
    }

    @Then("the user creation should fail with message {string}")
    public void the_user_creation_should_fail_with_message(String expectedMessage) {
        assertEquals(expectedMessage, creationResult);
    }

    @Then("the user creation should succeed")
    public void the_user_creation_should_succeed() {
        assertEquals("Success", creationResult);
    }
}
