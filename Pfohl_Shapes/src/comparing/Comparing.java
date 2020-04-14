package comparing;

import java.util.List;

public class Comparing {
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
