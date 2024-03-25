import java.util.Random;

public class NumberGenerator {
    private static final int SMALLEST_NUMBER=1;
    private static final int LARGEST_NUMBER=9;

    private boolean validateNumber(int number){
        if(SMALLEST_NUMBER<=number && number<=LARGEST_NUMBER){
            return true;
        }
        return false;
    }
    private int generateRandomNumber(){
        int randomNumber = new Random().nextInt(10);
        return randomNumber;
    }

    public int generateNumber(){
        int newNumber = generateRandomNumber();
        while(!validateNumber(newNumber)){
            newNumber = generateRandomNumber();
        }
        return newNumber;
    }
}
