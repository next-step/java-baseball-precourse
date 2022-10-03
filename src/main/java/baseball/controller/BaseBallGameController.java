package baseball.controller;

import baseball.domain.GameRule;
import baseball.model.GameResult;
import baseball.model.Judge;
import baseball.model.Player;
import baseball.model.RandomNumbersGenerator;
import baseball.view.InputView;
import java.util.ArrayList;

public class BaseBallGameController {
    private ArrayList<Integer> randomNumbers;

    public BaseBallGameController() {
        randomNumbers = new RandomNumbersGenerator().getRandomNumbers();
    }

    public void run() throws IllegalArgumentException {
        GameResult result = solveNumber(randomNumbers);
        System.out.println(result.printGameResult());

        while(result.getStrikeCnt() != GameRule.MAX_LENGTH) {
            result = solveNumber(randomNumbers);
            System.out.println(result.printGameResult());
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private GameResult solveNumber(ArrayList<Integer> randoms) throws IllegalArgumentException {

        System.out.print("숫자를 입력해주세요 : ");
        String userinput = InputView.getUserInput();

        return new Judge(randoms, new Player(userinput).getPlayerNumbers()).getGameResult();
    }

}
