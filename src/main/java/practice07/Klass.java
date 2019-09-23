package practice07;

public class Klass {

    private int number;

    public Klass(int number) {
        this.number = number;
    }

    int getNumber() {
        return this.number;
    }

    String getDisplayName() {
        return "Class " + this.number;
    }
}
