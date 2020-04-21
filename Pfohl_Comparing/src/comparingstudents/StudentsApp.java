package comparingstudents;

import comparingstudents.normalcomparing.ComparatorStudentByAverageGrade;
import comparingstudents.normalcomparing.ComparatorStudentByFirstName;
import comparingstudents.mycomparing.MyComparing;
import comparingstudents.normalcomparing.ComparatorStudentByLastName;
import comparingstudents.normalcomparing.ComparatorStudentByNumber;

import java.util.*;

/**
 * Objekt pro otestování třídění studentů.
 * @author Bruno Pfohl
 */
public class StudentsApp {
    public static void main(String[] args) {
        Student[] students = DataSource.loadDataAsArray();

        //test shodnosti objektu - chceme: nemusi byt stejny objekt, staci, kdyz ma stejna data
        System.out.println(students[0].equals(students[1]));

        // pouziti Comparable interface
        MyComparing.print(students);
        System.out.println("Sort by number");
        Arrays.sort(students); //students musi byt typove kompatibilni s interface Comparable
        MyComparing.print(students);

        List<Student> students1 = DataSource.loadDataAsList();
        MyComparing.print(students1);
        System.out.println("Sort by number");
        Collections.sort(students1); //students musi byt typove kompatibilni s interface Comparable
        MyComparing.print(students);

        //pouziti Comparator interface
        System.out.println("Sort by student number");
        Arrays.sort(students, new ComparatorStudentByNumber());
        MyComparing.print(students);

        System.out.println("Sort by firstname");
        Arrays.sort(students, new ComparatorStudentByFirstName());
        MyComparing.print(students);

        System.out.println("Sort by lastname");
        Arrays.sort(students, new ComparatorStudentByLastName());
        MyComparing.print(students);

        System.out.println("Sort by average grade");
        Arrays.sort(students, new ComparatorStudentByAverageGrade());
        MyComparing.print(students);
    }
}
