package baseball.common;

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
}
