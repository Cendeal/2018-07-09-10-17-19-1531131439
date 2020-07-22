package practice11;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements JoinListener {
    private final LinkedList<Klass> classes;

    public Teacher(int id, String name, int age) {
        this(id, name, age, new LinkedList<>());
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        this.classes.forEach(klass -> klass.registerListener(this));
    }

    public boolean isTeaching(Student student) {
        return classes.stream().anyMatch(klass -> klass.isIn(student));
    }


    @Override
    public String introduce() {
        List<String> list = classes.stream().map(klass ->
                String.valueOf(klass.getNumber())).collect(Collectors.toList());
        return super.introduce() +
                " I am a Teacher."
                + (classes.size() == 0 ?
                " I teach No Class." :
                String.format(" I teach Class %s.", String.join(", ", list)));
    }

    public String introduceWith(Student student) {
        boolean isTechTheStudent = this.isTeaching(student);
        return super.introduce() + String.format(" I am a Teacher. I%s teach %s.",
                isTechTheStudent ? "" : " don't", student.getName());
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    @Override
    public void update(Student student) {
        System.out.print(String.format("I am %s. I know %s has joined Class %s.\n",
                this.getName(), student.getName(), student.getKlass().getNumber()));
    }
}


