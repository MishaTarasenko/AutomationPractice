package ukma;

@Generate("HelloNewUser")
public class User {

    String name;

    @MinAge(18)
    int age;

    @ValidateEmail
    String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public static User create(String name, int age, String email) {
        User user = new User(name, age, email);
        try {
            Validator.validate(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Validation failed", e);
        }
        return user;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
