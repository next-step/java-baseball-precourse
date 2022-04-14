package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {

    private boolean play;
    private final int maxNumberLength;
    private Player computer;

    public NumberBaseballGame(int maxNumberLength){
        this.maxNumberLength = maxNumberLength;
        this.play = true;
        setUpPlayer();
    }

    private void setUpPlayer(){
        this.computer = new Player(this.randomNumbers());
    }

    private String randomNumbers(){
        String numbers = new String();
        while (numbers.length() < maxNumberLength){
            int randomNum = Randoms.pickNumberInRange(1, 9);

            if(numbers.indexOf(randomNum) < 0){
                numbers += randomNum;
            }
        }
        return numbers;
    }

    public boolean isPlay() { return this.play; }

    public boolean playing(String number) throws IllegalArgumentException{
        return true;
    }

    private int[] numberValidation(String number){
        int[] result = new int[ResultState.values().length+1];
        return result;
    }


    private void printResult(int[] result){

    }

    public boolean restart(){
        return true;
    }

    public void gameOver(){
    }
}
