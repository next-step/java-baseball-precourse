import java.util.Random;

public class BaseballScore {
    public int[] numbers;

    public void resetNumbers() {
        numbers = getRandomNumbers();
    }

    public TurnResult calculateResult(int[] numbers,int[] input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == numbers[i]) {
                strike++;
            } else if (Utils.contains(numbers, input[i])){
                ball++;
            }

        }

        return new TurnResult(strike, ball);
    }

    private int[] getRandomNumbers() {
        Random rand = new Random();
        int[] numbers = new int[3];

        int count = 0;

        while(count < 3){
            int randNum = rand.nextInt(10);

            if(!Utils.contains(numbers, randNum)){
                numbers[count] = randNum;
                count++;
            }
        }

        return numbers;
    }
}
