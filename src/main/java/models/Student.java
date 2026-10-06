package models;

public class Student {

    private String name;
    private int rollNo;
    private int year;
    private String dept;

    public Student(String name, String dept) {
        this.name = name;
        this.dept = dept;
        this.year = 1;
    }

    public Student(String name, int year, String dept) {
        this.name = name;
        this.year = year;
        this.dept = dept;
    }

    public Student(String name, int rollNo, int year, String dept) {
        this.name = name;
        this.rollNo = rollNo;
        this.year = year;
        this.dept = dept;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getRollNo() { return rollNo; }

    public void setRollNo(int rollNo) { this.rollNo = rollNo; }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public String getDept() { return dept; }

    public void setDept(String dept) { this.dept = dept; }
}
