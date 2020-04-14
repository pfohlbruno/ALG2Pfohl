package com.company;

public class Student implements CompareInterface, Comparable<Student>{
    private String firstName;
    private String lastName;
    private int studentNumber;

    public Student(String firstName, String lastName, int studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return String.format("%10s%10s%10d", firstName, lastName, studentNumber);
    }

    public boolean isBigger(Student student) {
        return this.studentNumber > student.studentNumber;
    }

    // Potřebné pro MyComparing.
    @Override
    public boolean isBigger(CompareInterface o) {
        return this.studentNumber > ((Student)o).studentNumber;
    }

    // Potřebné pro Comparable.
    @Override
    public int compareTo(Student o) {
        return this.studentNumber - o.studentNumber;
    }
}
