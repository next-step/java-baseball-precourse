public class Utils {
    static boolean contains(int[] numbers, int value){
        for(int number: numbers){
            if(number == value){
                return true;
            }
        }

        return false;
    }
}
