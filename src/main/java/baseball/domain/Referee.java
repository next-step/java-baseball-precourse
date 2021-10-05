package baseball.domain;

import baseball.utils.CommonUtils;
import baseball.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private int gameNumberDigits;
    private boolean isEndGame = false;
    private List<Integer> inputList = new ArrayList<>();

    public Referee(int gameNumberDigits) {
        this.gameNumberDigits = gameNumberDigits;
    }

    public boolean isEndGame(){
        return isEndGame;
    }

    public void ruleCheck(String readLine) {
        try{
            List<Integer> inputList = CommonUtils.stringToIntegerList(readLine);
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
