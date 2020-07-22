package practice08;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    public Person(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public String introduce(){
        return String.format("My name is %s. I am %d years old.", this.name, this.age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
