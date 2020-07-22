package practice08;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    private boolean isLeader() {
        return this.klass.isLeader(this);
    }

    @Override
    public String introduce() {
        return super.introduce() + String.format(" I am a Student. I am %s Class %d.",
                this.isLeader() ? "Leader of" : "at", this.klass.getNumber());
    }


    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
