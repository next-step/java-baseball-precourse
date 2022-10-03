package baseball.service;

import baseball.Constants.UserInputRange;
import baseball.domain.Round;
import baseball.view.UserInterface;
import baseball.utils.UserInputBaseBallNumberValidator;

import java.util.ArrayList;
import java.util.List;

public class RoundService {

    private final List<Integer> targetNumberList;
    private final List<Integer> userInputNumberList;

    private final Round round;

    public RoundService(List<Integer> targetNumberList){
        this.targetNumberList = targetNumberList;
        userInputNumberList = setUserInputNumberList();
        this.round = new Round();
    }

    private List<Integer> setUserInputNumberList(){
        String userInputString = UserInterface.askUserInputBaseBallNumber();
        new UserInputBaseBallNumberValidator(userInputString).isValidValue(); //expect throw if not valid

        List<Integer> userInputNumberList = new ArrayList<>();
        for(int i=0; i<userInputString.length(); i++){
            userInputNumberList.add(Character.getNumericValue(userInputString.charAt(i)));
        }
        return userInputNumberList;
    }

    public void startRound(){
        setStrikeCntAndBallCnt();
        printRoundResult();
    }

    private void setStrikeCntAndBallCnt(){
        int strikeCnt = 0;
        int ballCnt = 0;
        for(int i = 0; i< userInputNumberList.size(); i++){
            if(isStrike(i)){
                strikeCnt++;
                continue;
            }
            if(isBall(i)){
                ballCnt++;
            }
        }
        round.setStrikeCnt(strikeCnt);
        round.setBallCnt(ballCnt);
    }

    private boolean isStrike(int index){
        return targetNumberList.get(index).equals(userInputNumberList.get(index));
    }

    private boolean isBall(int index){
        return targetNumberList.contains(userInputNumberList.get(index));
    }

    private void printRoundResult(){
        UserInterface.printRoundResult(isNothing(), isWinning(), round.getBallCnt(), round.getStrikeCnt());
    }

    private boolean isNothing() {
        return round.getStrikeCnt() + round.getBallCnt() == 0;
    }

    public boolean isWinning(){
        return round.getStrikeCnt() == 3;
    }

}
