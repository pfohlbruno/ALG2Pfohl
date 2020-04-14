package com.company;

import java.util.List;

/**
 * Vytvoření vlastní metody pro třídění a vlastního rozhraní (interface).
 * @author Bruno Pfohl
 */
public class MyComparing {

    public static void main(String[] args) {
        Student[] students = DataSource.loadDataAsArray();
        print(students);
        System.out.println("Sort by number");
        sort(students);
        print(students);

    }

    // Třídí pole studentů.
    public static void sortByNumber(Student[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if(array[j-1].isBigger(array[j])){
                    Student temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    // Třídí pole objektu kompatibilnich s CompareInterface t.j. implementuji metodu "isBigger".
    public static void sort(CompareInterface[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if(array[j-1].isBigger(array[j])){
                    CompareInterface temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void print(Object[] array){
        for (Object object : array) {
            System.out.println(object);
        }
    }

    public static void print(List list){
        for (Object object : list) {
            System.out.println(object);
        }
    }

}
