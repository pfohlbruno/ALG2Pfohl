package comparingstudents.normalcomparing;

import comparingstudents.Student;

import java.util.Comparator;

/**
 * Porovnávač studentů podle jejich studentkého čísla (využívá generické rozhraní Comparator).
 * @author Bruno Pfohl
 */
public class ComparatorStudentByNumber implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return ((Integer)s1.getStudentNumber()).compareTo(s2.getStudentNumber());
    }
}
