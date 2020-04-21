package comparingstudents.normalcomparing;

import comparingstudents.Student;

import java.util.Comparator;

/**
 * Porovnávač studentů podle jejich průměrné známky (využívá generické rozhraní Comparator).
 * @author Bruno Pfohl
 */
public class ComparatorStudentByAverageGrade implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getAverageGrade(), s2.getAverageGrade());
    }
}
