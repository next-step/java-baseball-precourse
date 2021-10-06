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

    /**
     * 숫자야구게임 시작
     * <p>
     * 게임 상태를 START 설정하고, 게임에서 진행될 임의의 수를 생성한다. 임의의 수가 생성되면 사용자에게 입력값을 받는다.
     * </p>
     * <p>
     * 입력값을 비교하여 매치 결과를 출력한다. 숫자를 모두 맞히면 게임이 종료된다.
     * </p>
     */
    public void start() {
        setGameStatusStart();
        boolean isMakePickNumbers = makePickNumbers();

        if (isMakePickNumbers) {
            System.out.println(GameMessage.NEW_GAME.getMsg());
            readPickNumer();
        }
    }

    private void readPickNumer() {
        while (GameStatus.START.equals(getGameStatus())) {
            System.out.print(GameMessage.INPUT_PICK_NUMBER.getMsg());
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
            System.out.println(GameMessage.GAME_CLEAR.getMsg());

            int choiceGameStatus = choiceGameStatus();
            choiceGameStatusResult(choiceGameStatus);
        }
    }

    private int choiceGameStatus() {
        System.out.println(GameMessage.GAME_STATUS_CHOICE.getMsg());
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
