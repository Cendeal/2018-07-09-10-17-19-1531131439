package practice11;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Klass {
    private int number;
    private Student leader;
    private final Set<Student> members;
    private Collection<IKlassListenner> IKlassListenners;


    public Klass(int number) {
        this.members = new HashSet<>();
        this.setNumber(number);
        IKlassListenners = new ArrayList<>();
    }

    public void registerListener(IKlassListenner IKlassListenner) {
        this.IKlassListenners.add(IKlassListenner);
    }

    public void unregisterListener(IKlassListenner IKlassListenner) {
        this.IKlassListenners.remove(IKlassListenner);
    }

    public void notify(String msg) {
        IKlassListenners.forEach(IKlassListenner -> {
            IKlassListenner.update(msg);
        });
    }

    public void appendMember(Student student) {
        if (this.members.add(student)) {
            student.setKlass(this);
            String msg = String.format(" I know %s has joined Class %s.", student.getName(), student.getKlass().getNumber());
            this.notify(msg);
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
            String msg = String.format(" I know %s become Leader of Class %s.", student.getName(), student.getKlass().getNumber());
            this.notify(msg);
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
