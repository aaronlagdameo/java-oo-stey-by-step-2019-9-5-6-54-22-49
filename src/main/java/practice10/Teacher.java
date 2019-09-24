package practice10;

import java.beans.beancontext.BeanContextMembershipEvent;
import java.util.LinkedList;

public class Teacher extends Person {

    private LinkedList<Klass> klasses;
    private Klass klass;

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.klasses = new LinkedList<>();
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> klasses) {
        super(id, name, age);
        this.klasses = klasses;
    }

    public Klass getKlass() {
        return this.klass;
    }

    @Override
    public String introduce() {
        StringBuilder message = new StringBuilder(super.introduce() + " I am a Teacher. I teach ");

        if (this.getClasses().isEmpty()) {
            return message.append("No Class.").toString();
        }

        message.append("Class ");
        for (Klass klass: this.klasses) {
            message.append(klass.getNumber());
            if (this.klasses.getLast() != klass) {
                message.append(", ");
            }
        }

        return message.append(".").toString();
    }

    String introduceWith(Student student) {
        if (isTeaching(student)) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        }
        return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
    }

    LinkedList<Klass> getClasses() {
        return this.klasses;
    }

    boolean isTeaching(Student student) {
        return this.klasses.contains(student.getKlass());
    }
}
