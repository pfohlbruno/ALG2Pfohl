package comparingstudents.normalcomparing;

import comparingstudents.Student;

import java.util.Comparator;

/**
 * Porovnávač studentů podle jejich příjmení (využívá generické rozhraní Comparator).
 * @author Bruno Pfohl
 */
public class ComparatorStudentByLastName implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getLastName().compareTo(s2.getLastName());
    }
}
