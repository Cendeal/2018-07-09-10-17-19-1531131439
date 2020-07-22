package practice07;

public class Klass {
    private int number;

    public Klass(int number) {
        this.number = number;
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
