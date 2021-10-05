package baseball.controller;

import baseball.domain.GameConfig;
import baseball.domain.GameMessage;
import baseball.domain.GameStatus;
import baseball.domain.PickNumberMatchResultView;
import baseball.service.GameService;

import static baseball.AppConfig.*;
import static baseball.domain.PickNumbers.makePickNumbers;
import static baseball.domain.PickNumbers.pickNumbersClear;
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

    public void start() {
        setGameStatusStart();
        boolean isMakePickNumbers = makePickNumbers();

        if (isMakePickNumbers) {
            System.out.println("==========[ New Game ]==========");
            readPickNumer();
        }
    }

    private void readPickNumer() {
        while (GameStatus.START.equals(getGameStatus())) {
            System.out.print("숫자를 입력해주세요 : ");
            String readPickNumber = readLine();
            System.out.println(readPickNumber);
            comparePickNumber(readPickNumber);
        }
    }

    private void comparePickNumber(String readPickNumber) {
        boolean isValidReadPickNumber = gameService.isValidReadPickNumber(readPickNumber);
        if (isValidReadPickNumber) {
            PickNumberMatchResultView pickNumberMatchResult = gameService.comparePickNumber(readPickNumber);
            System.out.println(pickNumberMatchResult.toString());

            gameResult(pickNumberMatchResult);
        }
    }

    private void gameResult(PickNumberMatchResultView pickNumberMatchResult) {
        if (pickNumberMatchResult.getStrike() == GameConfig.PICK_NUMBER_SIZE.getValue()) {
            pickNumbersClear();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");

            int choiceGameStatus = choiceGameStatus();
            choiceGameStatusResult(choiceGameStatus);
        }
    }

    private int choiceGameStatus() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String readGameStatus = readLine();
        System.out.println(readGameStatus);

        return Integer.parseInt(readGameStatus);
    }

    private void choiceGameStatusResult(int choiceGameStatus) {
        if (GameStatus.START.getGameStatus() == choiceGameStatus) {
            makePickNumbers();
            return;
        }
        setGameStatusEnd();
        System.out.println(GameMessage.GAME_OVER.getMsg());
    }

}
