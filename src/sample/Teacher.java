package sample;

public class Teacher {

    private String name;
    private String lastname;
    private int exp;

    public Teacher(String name, String lastname, int exp) {
        this.name = name;
        this.lastname = lastname;
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getExp() {
        return exp;
    }
}
