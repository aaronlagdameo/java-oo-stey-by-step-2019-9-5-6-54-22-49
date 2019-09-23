package practice09;

public class Student extends Person {

    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return this.klass;
    }

    @Override
    public String introduce() {
        String introduction = super.introduce() + " I am a Student.";
        if (this.klass.getLeader() == null) {
            introduction += " I am at " + this.klass.getDisplayName() + ".";
        } else if (this.getName().equals(this.klass.getLeader().getName())) {
            introduction += " I am Leader of " + this.klass.getDisplayName() + ".";
        }
        return introduction;
    }
}
