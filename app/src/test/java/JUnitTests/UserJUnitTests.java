package JUnitTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ukma.User;
import ukma.Validator;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class UserJUnitTests {


    @ParameterizedTest
    @ValueSource(strings = {"@sasha.gmail.com", "not.email"})
    public void cantCreateUserWithWrongEmail(String email) {
        User user = null;
        try {
            user = User.create("Name", 18, email);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNull(user);
    }

    @Test
    public void cantCreateUserWithAgeUnder18() {
        User user = null;
        try {
            user = User.create("Name", 16, "email@gmail.com");
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNull(user);
    }

    @Test
    public void createUserWithCorrectData() throws IllegalAccessException {
        String name = "Name";
        String email = "email@gmail.com";
        Integer age = 18;
        assumeTrue(name != null, "Name is null");
        assumeTrue(Validator.validateEmail(email), "Email is incorrect");
        assumeTrue(age >= 18, "Age must be greater than 18");
        User user = User.create(name, age, email);
    }
}
