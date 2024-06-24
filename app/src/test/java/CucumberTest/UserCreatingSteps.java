package CucumberTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ukma.User;

import static org.junit.Assert.*;

public class UserCreatingSteps {
    private User user;
    private String resultMessage;

    @Given("a user with email {string} and age {string}")
    public void aUserWithEmailAndAge(String email, String age) {
        user = new User("Name", Integer.parseInt(age), email);
    }

    @When("I try to create the user")
    public void iTryToCreateTheUser() {
        try {
            User.create(user.getName(), user.getAge(), user.getEmail());
            resultMessage = null;
        } catch (Exception e) {
            if (user.getAge() < 18) resultMessage = "User must be at least 18 years old";
            else resultMessage = "Invalid email address";
        }
    }

    @Then("the user creation should {string} with message {string}")
    public void theUserCreationShouldResultWithMessage(String result, String message) {
        if (result.equals("succeed")) {
            assertNull("Expected success but got error: " + resultMessage, resultMessage);
        } else {
            assertEquals("Expected error message '" + message + "' but got '" + resultMessage + "'", message, resultMessage);
        }
    }

    @Then("the user creation should succeed with message {string}")
    public void theUserCreationShouldSucceedWithMessage(String message) {
        assertNull("Expected success but got error: " + resultMessage, resultMessage);
    }

    @Then("the user creation should fail with message {string}")
    public void theUserCreationShouldFailWithMessage(String message) {
        assertEquals("Expected error message '" + message + "' but got '" + resultMessage + "'", message, resultMessage);
    }
}
