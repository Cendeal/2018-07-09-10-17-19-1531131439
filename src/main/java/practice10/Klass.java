package practice10;


import java.util.HashSet;
import java.util.Set;

public class Klass {
    private int number;
    private Student leader;
    private final Set<Integer> memberIds;


    public Klass(int number) {
        this.memberIds = new HashSet<>();
        this.setNumber(number);
    }

    public void appendMember(Student student) {
        this.memberIds.add(student.getId());
    }

    public boolean isIn(Student student) {
        return this.memberIds.contains(student.getId());
    }

    public boolean isLeader(Student student) {
        return this.leader != null && this.leader.getId() == student.getId();
    }

    public void assignLeader(Student student) {
        if (isIn(student)) {
            this.leader = student;
            return;
        }
        System.out.print("It is not one of us.\n");
    }

    public Student getLeader() {
        return this.leader;
    }

    public String getDisplayName() {
        return String.format("Class %d", this.getNumber());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
