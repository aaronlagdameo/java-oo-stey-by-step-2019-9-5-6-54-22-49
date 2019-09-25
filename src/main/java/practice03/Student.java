package practice03;

import static java.lang.String.format;

public class Student extends Person {

    private int klass;

    public Student(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public int getKlass() {
        return this.klass;
    }

    @Override
    public String introduce() {
        return format("I am a Student. I am at Class %s.", klass);
    }
}
