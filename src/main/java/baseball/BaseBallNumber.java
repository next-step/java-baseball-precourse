package baseball;

import java.util.Arrays;

public class BaseBallNumber {

    private BaseBallAnswer baseBallAnswer;

    public BaseBallNumber() {
        baseBallAnswer = new BaseBallAnswer();
    }


    public void printAnswer() {
        System.out.println(Arrays.toString(baseBallAnswer.getAnswer().toArray()));
    }
}
