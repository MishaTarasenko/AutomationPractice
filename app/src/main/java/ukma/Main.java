package ukma;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n");

        try {
            User user = User.create("Sasha", 15,"not@email.com");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user = User.create("Misha", 20, "not.email");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        HelloUser.helloFromUser("This is new hello string from User");

        System.out.println("\n");
    }
}