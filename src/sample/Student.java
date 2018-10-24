package sample;

public class Student {
    private String name;
    private String lastname;
    private int course;

    public Student(String name, String lastname, int course) {
        this.name = name;
        this.lastname = lastname;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getCourse() {
        return course;
    }
}
