package practice09;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }


    private boolean isTeach(Klass klass) {
        return this.getKlass().getNumber() == klass.getNumber();
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher."
                + (this.klass == null ? " I teach No Class." : String.format(" I teach %s.", this.klass.getDisplayName()));
    }

    public String introduceWith(Student student) {
        boolean isTechTheStudent = this.isTeach(student.getKlass());
        return super.introduce() + String.format(" I am a Teacher. I%s teach %s.",
                isTechTheStudent ? "" : " don't", student.getName());
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
