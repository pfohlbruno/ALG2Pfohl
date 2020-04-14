package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentsApp {
    public static void main(String[] args) {
        Student[] arrStudents = DataSource.loadDataAsArray();
        MyComparing.print(arrStudents);
        System.out.println("Sort by number");
        Arrays.sort(arrStudents); // Students musí být typově kompatibilní s interfacem Comparable.
        MyComparing.print(arrStudents);

        List<Student> listStudents = DataSource.loadDataAsList();
        MyComparing.print(listStudents);
        System.out.println("Sort by number");
        Collections.sort(listStudents); // Students musí být typově kompatibilní s interfacem Comparable
        MyComparing.print(listStudents);
    }
}
