package baseball.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    private Utils(){
        throw new IllegalStateException();
    }

    public static int maxOf(int[] array){
        int max = array[0];
        for (int val : array){
            max = Math.max(val, max); 
        }
        return max;
    }
    public static int minOf(int[] array){
        int min = array[0];
        for (int val : array){
            min = Math.min(val, min);
        }
        return min;
    }

    public static Set<Integer> setOf(int[] array){
        Set<Integer> set = new HashSet<>();
        for (int idx = 0; idx < array.length; idx++){
            set.add(array[idx]);
        }
        return set;
    }

    public static int[] convertArrayFrom(List<Integer> intList){
        int[] array = new int[intList.size()];
        int idx = 0;
        for (Integer number : intList){
            array[idx] = number.intValue();
            idx++;
        }
        return array;
    }
}
