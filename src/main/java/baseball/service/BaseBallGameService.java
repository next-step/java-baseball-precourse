package baseball.service;

import baseball.Constants.UserInputRange;
import baseball.domain.BaseBallGame;
import baseball.Constants.GameStatus;
import baseball.view.UserInterface;
import baseball.utils.UserInputGameStatusNumberValidator;
import baseball.utils.UserInputValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseBallGameService {

    public void startBaseBallGame(){
        BaseBallGame baseBallGame = new BaseBallGame(generateTargetNumber());
        //baseBallGame.getTargetNumberList().forEach(System.out::println);
        do {
            RoundService roundService = new RoundService(baseBallGame.getTargetNumberList());
            roundService.startRound();
            if(roundService.isWinning()){
                baseBallGame.setGameStatus(GameStatus.END);
            }
        } while(GameStatus.START == baseBallGame.getGameStatus());

        if(GameStatus.START == isStartNewGame()){
            startBaseBallGame();
        }
    }

    private List<Integer> generateTargetNumber(){
        Set<Integer> targetNumberSet = new LinkedHashSet<>();
        while(targetNumberSet.size() != UserInputRange.INPUT_BASEBALL_MAX_DIGIT){
            targetNumberSet.add(Randoms.pickNumberInRange(UserInputRange.INPUT_BASEBALL_MIN_NUM, UserInputRange.INPUT_BASEBALL_MAX_NUM));
        }
        return new ArrayList<>(targetNumberSet);
    }

    private GameStatus isStartNewGame(){
        String userInputGameStatusString = UserInterface.askUserInputGameStatusNumber();
        UserInputValidator userInputValidator = new UserInputGameStatusNumberValidator(userInputGameStatusString);
        userInputValidator.isValidValue();  //expect throw if not valid
        int userInputGameStatus = Integer.parseInt(userInputGameStatusString);

        return GameStatus.searchKey(userInputGameStatus);
    }


}
