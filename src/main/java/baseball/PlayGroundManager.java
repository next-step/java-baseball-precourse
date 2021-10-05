package baseball;

import java.util.ArrayList;

public class PlayGroundManager {
    private static final String SUCCESS_MSG = "3개의 숫자를 모두 맞추셨습니다!";
    private static final String REGAME_REQUEST_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_FINISHED_MSG = "게임 끝";
    private static final String NEW_LINE = "\n";
    private static final String INPUT_BALL_NUMBER_ERROR_MSG = "[ERROR] 입력한 값이 유효하지 않습니다. 1~9 사이의 정수값 3개를 입력해주세요...";

    private static PlayGround playGround;

    public static void standByGame() {
        if (playGround == null) {
            playGround = new PlayGround();
        }

        playGround.setComputerTrial(new PlayerState(new RandomInputGenerator().genRandomInts()));
    }

    public static boolean proceedGame(String userInput) {
        try {
            ArrayList<Integer> inputBallNumbers = new InputParser().parse(userInput);

            return proceedGameInternal(inputBallNumbers);
        }
        catch (IllegalArgumentException e){
            System.out.println(INPUT_BALL_NUMBER_ERROR_MSG);
        }

        return true;
    }

    private static boolean proceedGameInternal(ArrayList<Integer> inputBallNumbers) {
        if (inputBallNumbers.size() == 0) return true;

        boolean isGameEnd = playGround.run(new PlayerState(inputBallNumbers));

        return isGameEnd ? afterGameEnd() : true;
    }

    private static boolean afterGameEnd() {
        System.out.println(SUCCESS_MSG + NEW_LINE + REGAME_REQUEST_MSG);

        REGAME_FLAG reGameAnswer = new PlayGroundReGameAsker().getReGameAnswer();

        if (reGameAnswer == REGAME_FLAG.WANT) {
            System.out.println(GAME_FINISHED_MSG);
            standByGame();
        }

        return reGameAnswer == REGAME_FLAG.WANT;
    }
}
