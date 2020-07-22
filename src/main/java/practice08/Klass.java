package practice08;

public class Klass {
    private int number;
    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public boolean isLeader(Student student){
        return this.leader != null && this.leader.getId() == student.getId();
    }

    public void assignLeader(Student student){
        this.leader = student;
    }

    public Student getLeader(){
        return this.leader;
    }
    public String getDisplayName(){
        return String.format("Class %d",this.getNumber());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
