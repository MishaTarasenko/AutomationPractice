package ukma;

import java.io.IOException;
import java.util.List;

import static ukma.CheckEmail.isValidEmail;

public class Main {
    public static void main(String[] args) {

        List<UserModel> testUser = null;
        try {
            testUser = UserModel.getAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (UserModel user : testUser) {
            System.out.println("Is the email '" + user.getEmail() + "' valid? " + isValidEmail(user.getEmail()));
        }
    }
}