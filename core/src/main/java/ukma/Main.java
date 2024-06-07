package ukma;

import static ukma.CheckEmail.isValidEmail;

public class Main {
    public static void main(String[] args) {

        UserModel[] testUser = {
                new UserModel(1, "Misha", "misha@gmail.com"),
                new UserModel(2, "Sasha", "@sasha.gmail.com"),
                new UserModel(3, "Lyosha", "lyosha.gmail.com")
        };

        for (UserModel user : testUser) {
            System.out.println("Is the email '" + user.getEmail() + "' valid? " + isValidEmail(user.getEmail()));
        }
    }
}