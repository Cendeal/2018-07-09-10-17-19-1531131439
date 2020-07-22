package practice11;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Klass {
    private int number;
    private Student leader;
    private final Set<Student> members;
    private Collection<JoinListener> joinListeners;


    public Klass(int number) {
        this.members = new HashSet<>();
        this.number = number;
        joinListeners = new ArrayList<>();
    }

    public void registerListener(JoinListener joinListener) {
        this.joinListeners.add(joinListener);
    }

    public void unregisterListener(JoinListener joinListener) {
        this.joinListeners.remove(joinListener);
    }

    public void notify(Student student) {
        this.joinListeners.forEach(joinListener -> {
            joinListener.update(student);
        });
    }

    public void appendMember(Student student) {
        if (this.members.add(student)) {
            this.notify(student);
        }
    }

    public boolean isIn(Student student) {
        return student.getKlass().getNumber() == this.getNumber();
//        return this.members.contains(student);
    }

    public boolean isLeader(Student student) {
        return this.leader != null && this.leader.getId() == student.getId();
    }

    public void assignLeader(Student student) {
        if (this.isIn(student)) {
            this.leader = student;
            return;
        }
//        if (this.members.contains(student)) {
//            this.leader = student;
//            return;
//        }
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
