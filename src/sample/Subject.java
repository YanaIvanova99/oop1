package sample;

import java.util.ArrayList;

public class Subject {
    private String name;
    private int hours;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;

    public Subject (String name, int hours) //конструктор
    {
        this.name=name;
        this.hours=hours;
        teachers= new ArrayList<>();
        students= new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) //метод для добавления в коллекцию teachers
    {
        teachers.add(teacher);
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }

    public String getName() { //геттер
        return name;
    }

    public int getHours() {
        return hours;
    }

    public ArrayList<Teacher> getTeachers()
    {
        return teachers;
    }

    public ArrayList<Student> getStudents()
    {
        return students;
    }
}
