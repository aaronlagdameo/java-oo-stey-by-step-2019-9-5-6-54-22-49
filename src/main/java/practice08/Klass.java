package practice08;

public class Klass {

    private int number;
    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    int getNumber() {
        return this.number;
    }

    String getDisplayName() {
        return "Class " + this.number;
    }

    public void assignLeader(Student leader) {
        this.leader = leader;
    }

    public Student getLeader() {
        return this.leader;
    }
}

