package ukma;

import java.util.Objects;

public class Phone {

    private int yearOfRelease;
    String model;

    public Phone(int yearOfRelease, String model) {
        this.yearOfRelease = yearOfRelease;
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return yearOfRelease == phone.yearOfRelease && Objects.equals(model, phone.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearOfRelease, model);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "yearOfRelease=" + yearOfRelease +
                ", model='" + model + '\'' +
                '}';
    }
}
