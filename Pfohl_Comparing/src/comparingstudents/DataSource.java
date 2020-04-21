package comparingstudents;

import java.util.Arrays;
import java.util.List;

/**
 * Objekt pro získání seznamu studentů.
 * @author Bruno Pfohl
 */
public class DataSource {
    private static final Student[] DATA = {
            new Student("Lucie", "Střední", 345, new int[] { 1, 2, 3, 4, 5}),
            new Student("Dan", "Malý", 123, new int[] { 1, 1, 2, 1, 1}),
            new Student("Žirafa", "Velká", 567, new int[] { 5, 2, 4, 1, 1, 2})
    };

    public static Student[] loadDataAsArray() {
        return Arrays.copyOf(DATA, DATA.length);
    }

    public static List<Student> loadDataAsList() {
        return Arrays.asList(DATA);
    }
}