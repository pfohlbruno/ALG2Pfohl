package comparingstudents.mycomparing;

import comparingstudents.Student;

/**
 * Porovnávač studentů podle jejich průměrné známky.
 * @author Bruno Pfohl
 */
public class MyComparatorStudentByAverageGrade implements ComparatorInterface {
    @Override
    public boolean bigger(Object o1, Object o2) {
        return Double.compare(((Student) o1).getAverageGrade(), ((Student) o2).getAverageGrade()) > 0;
    }
}
