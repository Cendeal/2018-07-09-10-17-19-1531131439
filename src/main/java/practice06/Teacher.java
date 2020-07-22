package practice06;

public class Teacher extends Person {
    private Integer klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Integer klass) {
        super(name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return String.format("My name is %s. I am %d years old. I am a Teacher.", this.getName(), this.getAge())
                + (this.klass == null ? " I teach No Class." : String.format(" I teach Class %d.", this.klass));
    }

    public int getKlass() {
        return klass;
    }

    public void setKlass(int klass) {
        this.klass = klass;
    }
}
