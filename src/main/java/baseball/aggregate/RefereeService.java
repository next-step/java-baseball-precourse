package baseball.aggregate;

import baseball.domain.Computer;
import baseball.domain.Decision;
import baseball.domain.StrikeZone;
import baseball.domain.User;
import baseball.utils.CommonUtils;
import baseball.utils.ValidateUtils;
import baseball.view.ConsoleView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RefereeService {
    private int gameNumberDigits;
    private int minNumber;
    private int maxNumber;

    public RefereeService(int gameNumberDigits, int minNumber, int maxNumber) {
        this.gameNumberDigits = gameNumberDigits;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    public void ready(Computer computer){
        computer.makeQuiz(minNumber, maxNumber);
    }

    public void gameDoingCheck(User user, Computer computer){
        if(Decision.SUCCESS.equals(user.getDecision()) && "2".equals(user.getReadLine())){
            user.setIsEndPlay(true);
            return;
        }
        if(Decision.SUCCESS.equals(user.getDecision()) && "1".equals(user.getReadLine())){
            user.setIsEndPlay(false);
            user.setDecision(Decision.DOING);
            ready(computer);
            return;
        }
        ruleCheck(user);
        decision(user, computer);
        ConsoleView.decision(user);
    }

    public void ruleCheck(User user) {
        try{
            List<Integer> inputList = CommonUtils.stringToIntegerList(user.getReadLine(), minNumber, maxNumber);
            ValidateUtils.lengthCheck(inputList, gameNumberDigits);
            ValidateUtils.duplicateNumberCheck(inputList);
            user.setDecision(Decision.DOING);
            user.setInputList(inputList);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            user.setDecision(Decision.FAIL);
        }
    }

    public void decision(User user, Computer computer) {
        List<StrikeZone> decisionList = new ArrayList<>();
        if(Decision.FAIL.equals(user.getDecision())){
            user.setDecisionList(decisionList);
            return;
        }
        for(int i = 0; i < gameNumberDigits; i++){
            decisionList.add(callDecision(computer.getQuizList(), user.getInputList(), i));
        }
        user.setDecisionList(decisionList);
        user.setDecision(Decision.DOING);
        int countStrike = Collections.frequency(user.getDecisionList(), StrikeZone.STRIKE);
        if(countStrike == gameNumberDigits){
            user.setDecision(Decision.SUCCESS);
        }
    }

    public StrikeZone callDecision(List<Integer> quizList, List<Integer> inputList, int i) {
        StrikeZone result = StrikeZone.NOTHING;
        if(quizList.contains(inputList.get(i))){
            result = StrikeZone.BALL;
        }
        if(quizList.get(i) == inputList.get(i)){
            result = StrikeZone.STRIKE;
        }
        return result;
    }
}
