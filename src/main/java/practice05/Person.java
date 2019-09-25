package practice05;

import static java.lang.String.format;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String introduce() {
        return backIntroduce();
    }

    private String backIntroduce() {
        return format("My name is %s. I am %s years old.", name, age);
    }
}
