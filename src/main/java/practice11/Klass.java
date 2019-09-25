package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Klass extends Observable {

    private int number;
    private Student leader;
    private List<Student> students;

    public Klass(int number) {
        this.number = number;
        this.students = new ArrayList<>();
    }

    int getNumber() {
        return this.number;
    }

    String getDisplayName() {
        return "Class " + this.number;
    }

    public void assignLeader(Student leader) {
        if (leader.getKlass().getNumber() != this.number) {
            System.out.print("It is not one of us.\n");
        } else {
            this.leader = leader;
            setChanged();
            notifyObservers(leader);
        }
    }

    public Student getLeader() {
        if (this.leader == null && !this.students.isEmpty()) {
            return this.students.get(0);
        }
        return this.leader;
    }

    void appendMember(Student student) {
        student.getKlass().number = getNumber();
        this.setChanged();
        this.notifyObservers(student);
    }
}
