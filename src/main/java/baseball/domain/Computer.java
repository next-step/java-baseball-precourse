package baseball.domain;

import baseball.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private int gameNumberDigits;
    private List<Integer> quizList = new ArrayList<>();

    public Computer(int gameNumberDigits) {
        this.gameNumberDigits = gameNumberDigits;
    }

    public void makeQuiz(int minNumber, int maxNumber){
        quizList = CommonUtils.createRandomList(gameNumberDigits, minNumber, maxNumber);
    }

    public List<Integer> getQuizList(){
        return quizList;
    }
}
