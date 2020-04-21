package comparingstudents;

import comparingstudents.mycomparing.CompareInterface;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Objekt reprezentující studenta.
 * @author Bruno Pfohl
 */
public class Student implements CompareInterface, Comparable<Student>{
    private String firstName;
    private String lastName;
    private int studentNumber;
    private ArrayList<Integer> grades;

    public Student(String firstName, String lastName, int studentNumber, int[] grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.grades = new ArrayList<Integer>();

        for (Integer grade : grades) {
            this.grades.add(grade);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public double getAverageGrade() {
        double sum = 0;

        for (Integer grade : this.grades) {
            sum += grade;
        }

        return sum / this.grades.size();
    }

    @Override
    public String toString() {
        return String.format("%10s%10s%10d%10f",firstName, lastName, studentNumber, getAverageGrade());
    }

    public boolean isBigger(Student student) {
        return this.studentNumber > student.studentNumber;
    }

    // Potřebné pro MyComparing.
    @Override
    public boolean isBigger(CompareInterface o) {
        return this.studentNumber > ((Student)o).studentNumber;
    }

    // Potřebné pro Comparing.
    @Override
    public int compareTo(Student o) {
        return this.studentNumber - o.studentNumber;
    }

    // Při změně equals změnit i hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + this.studentNumber;
        return hash;
    }

    //default in Object
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.studentNumber != other.studentNumber) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }
}
