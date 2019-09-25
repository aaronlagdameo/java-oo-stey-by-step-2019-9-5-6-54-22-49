package practice11;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import static java.lang.String.format;

public class Teacher extends Person implements Observer {

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
        this.klasses.forEach(klass -> klass.addObserver(this));
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
        for (Klass klass : this.klasses) {
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
        for (Klass klass : klasses) {
            if (student.isIn(klass)) {
                String message = format("I am %s. I know %s has joined %s.\n", getName(), student.getName(), student.getKlass().getDisplayName());
                System.out.print(message);
            }
            if (student.equals(klass.getLeader())) {
                String message = format("I am %s. I know %s become Leader of %s.\n", getName(), student.getName(), student.getKlass().getDisplayName());
                System.out.print(message);
            }
        }
        return this.klasses.contains(student.getKlass());
    }


    @Override
    public void update(Observable o, Object arg) {
        Student student = (Student) arg;
        isTeaching(student);
    }
}
