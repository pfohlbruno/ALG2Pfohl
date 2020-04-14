package com.company;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bruno Pfohl
 */
public class DataSource {
    private static final Student[] DATA = {
            new Student("Lucie", "Střední", 345),
            new Student("Dan", "Malý", 123),
            new Student("Žirafa", "Velká", 567)
    };

    public static Student[] loadDataAsArray() {
        return Arrays.copyOf(DATA, DATA.length);
    }

    public static List<Student> loadDataAsList() {
        return Arrays.asList(DATA);
    }
}