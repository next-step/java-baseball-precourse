package baseball.controller;

import baseball.domain.GameStatus;
import baseball.domain.PickNumberMatchResultView;
import baseball.service.GameService;

import static baseball.domain.PickNumbers.makePickNumbers;
import static nextstep.utils.Console.readLine;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /* 싱글톤 테스트용 */
    public GameService getGameService() {
        return gameService;
    }

    public void start(GameStatus gameStatus) {
        boolean isMakePickNumbers = makePickNumbers();

        if (isMakePickNumbers) {
            System.out.println("==========[ New Game ]==========");
            gameStart(gameStatus);
        }

    }

    private void gameStart(GameStatus gameStatus) {
        while (GameStatus.START.equals(gameStatus)) {
            System.out.print("숫자를 입력해주세요 : ");
            String readPickNumber = readLine();

            PickNumberMatchResultView pickNumberMatchResult = gameService.compareBallNumber(readPickNumber);
            System.out.println(pickNumberMatchResult.toString());
        }
    }
}
