package ukma;

public class BrokenPhone {
    private int yearOfRelease;
    String model;

    public BrokenPhone(int yearOfRelease, String model) {
        this.yearOfRelease = yearOfRelease;
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return "hello world".hashCode();
    }

    @Override
    public String toString() {
        return "BrokenPhone{" +
                "yearOfRelease=" + yearOfRelease +
                ", model='" + model + '\'' +
                '}';
    }
}
