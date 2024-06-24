package ukma;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static void validate(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MinAge.class)) {
                MinAge minAge = field.getAnnotation(MinAge.class);
                field.setAccessible(true);
                int value = field.getInt(obj);
                if (value < minAge.value()) {
                    throw new IllegalArgumentException("Age must be at least " + minAge.value());
                }
            } else if (field.isAnnotationPresent(ValidateEmail.class)) {
                String email = (String) field.get(obj);
                if(!validateEmail(email))
                    throw new IllegalArgumentException("Invalid email format");
            }
        }
    }

    public static boolean validateEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
