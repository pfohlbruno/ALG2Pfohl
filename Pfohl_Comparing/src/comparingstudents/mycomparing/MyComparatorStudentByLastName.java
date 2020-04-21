package comparingstudents.mycomparing;

import comparingstudents.Student;

import java.util.Comparator;

/**
 * Porovnávač studentů podle jejich příjmení.
 * @author Bruno Pfohl
 */
public class MyComparatorStudentByLastName implements ComparatorInterface {
    @Override
    public boolean bigger(Object o1, Object o2) {
        return ((Student)o1).getLastName().compareTo(((Student)o2).getLastName()) > 0;
    }
}
