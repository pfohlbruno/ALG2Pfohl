package comparingstudents.normalcomparing;

import comparingstudents.Student;

import java.util.Comparator;

/**
 * Porovnávač studentů podle jejich křestního jména (využívá generické rozhraní Comparator).
 * @author Bruno Pfohl
 */
public class ComparatorStudentByFirstName implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getFirstName().compareTo(s2.getFirstName());
    }
}
