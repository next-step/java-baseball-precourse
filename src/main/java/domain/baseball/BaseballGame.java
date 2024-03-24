package domain.baseball;

import domain.baseball.constants.CommandType;

import java.util.Arrays;
import java.util.Random;

public class BaseballGame {
    private int[] computerNumber;
    private Hint hint;

    public BaseballGame(){
        computerNumber = new int[10];
        this.hint = new Hint();
    }

    public void initComputerNumber() {
        Arrays.fill(computerNumber, -1);
        Random randomGenerator = new Random();
        int number = 0;
        int count = 2;
        while(count >= 0){
            number = randomGenerator.nextInt(9) + 1;
            if (computerNumber[number] == -1) {
                computerNumber[number] = count--;
            }
        }
    }
    public boolean isQuit(int command) {
        return CommandType.QUIT.getNumber() == command;
    }

    public Hint updateHint(int number) {
        hint.init();
        int digit = 0;

        for(int position = 0; number > 0; position++, number /= 10){
            digit = number % 10;
            if(computerNumber[digit] == position) {
                hint.addStrikeCount();
                continue;
            }
            if(computerNumber[digit] != -1){
                hint.addBallCount();
            }
        }
        return hint;
    }

    public int getComputerNumber() {
        int number = 0;
        for (int i = 1; i < 10; i++) {
            if (computerNumber[i] != -1) {
                number += i * (int)Math.pow(10, computerNumber[i]);
            }
        }
        return number;
    }

    public void setComputerNumber(int number) {
        Arrays.fill(computerNumber, -1);
        int position = 0;
        while (number > 0) {
            int digit = number % 10;
            computerNumber[digit] = position++;
            number /= 10;
        }
    }
}
