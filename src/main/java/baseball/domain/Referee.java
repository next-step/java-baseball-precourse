package baseball.domain;

import baseball.utils.CommonUtils;
import baseball.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private int gameNumberDigits;
    private boolean isEndGame = false;
    private List<Integer> inputList = new ArrayList<>();
    private List<Integer> quizList;

    public Referee(int gameNumberDigits, List<Integer> quizList) {
        this.gameNumberDigits = gameNumberDigits;
        this.quizList = quizList;
    }

    public boolean isEndGame(){
        return isEndGame;
    }

    public void ruleCheck(String readLine, int minNumber, int maxNumber) {
        try{
            List<Integer> inputList = CommonUtils.stringToIntegerList(readLine, minNumber, maxNumber);
            ValidateUtils.lengthCheck(inputList, gameNumberDigits);
            ValidateUtils.duplicateNumberCheck(inputList);
            this.inputList = inputList;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputList = new ArrayList<>();
        }
    }

    public List<Integer> getInputList(){
        return inputList;
    }
}
