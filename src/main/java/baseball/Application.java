package baseball;

import nextstep.utils.Console;

import java.util.ArrayList;

public class Application {

    public static final String SUCCESS_MSG = "3개의 숫자를 모두 맞추셨습니다!";
    public static final String REGAME_REQUEST_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_FINISHED_MSG = "게임 끝";
    public static final String INPUT_BALL_NUBMER_ERROR_MSG = "[ERROR] 입력한 값이 유효하지 않습니다. 1~9 사이의 정수값 3개를 입력해주세요...";
    public static final String REQUEST_INPUT_MSG = "숫자를 입력해주세요: ";
    public static final String WANT_REGAME_MSG = "1";
    public static final String DO_NOT_WANT_REGAME_MSG = "2";
    public static final String NEW_LINE = "\n";
    public static final String INPUT_REGAME_ERROR_MSG = "[ERROR] 1 또는 2를 입력해야 합니다. 다시 입력해 주세요...";

    private static PlayGround playGround;

    public static void main(String[] args) {
        standByGame();

        boolean isContinuePlaying = true;

        while (isContinuePlaying) {
            String input = readInput();

            isContinuePlaying = proceedGame(parseInput(input));
        }
    }

    private static String readInput() {
        System.out.println(REQUEST_INPUT_MSG);

        return Console.readLine();
    }

    private static ArrayList<Integer> parseInput(String input) {
        try {
            return new InputParser().parse(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_BALL_NUBMER_ERROR_MSG);

            return new ArrayList<>();
        }
    }

    private static boolean proceedGame(ArrayList<Integer> inputBallNumbers) {
        if (inputBallNumbers.size() == 0) return true;

        boolean isGameEnd = playGround.run(new Trial(inputBallNumbers));

        if (!isGameEnd) return true;

        return isGameEnd ? afterGameEnd() : true;
    }

    private static boolean afterGameEnd() {
        System.out.println(SUCCESS_MSG + NEW_LINE + REGAME_REQUEST_MSG);

        REGAME_FLAG regameAnswer = getRegameAnswer();

        if (regameAnswer == REGAME_FLAG.WANT) {
            System.out.println(GAME_FINISHED_MSG);
            standByGame();
        }

        return regameAnswer == REGAME_FLAG.WANT;
    }

    private static REGAME_FLAG getRegameAnswer() {
        REGAME_FLAG regameFlag = REGAME_FLAG.NONE;

        while (regameFlag == REGAME_FLAG.NONE) {
            regameFlag = verifyRegameAnswer(Console.readLine());
        }

        return regameFlag;
    }

    private static REGAME_FLAG verifyRegameAnswer(String input) {
        if (input.equals(WANT_REGAME_MSG)) {
            return REGAME_FLAG.WANT;
        }

        if (input.equals(DO_NOT_WANT_REGAME_MSG)) {
            return REGAME_FLAG.NOT_WANT;
        }

        System.out.println(INPUT_REGAME_ERROR_MSG);

        return REGAME_FLAG.NONE;
    }

    private static void standByGame() {
        if (playGround == null) {
            playGround = new PlayGround();
        }

        playGround.setComputerTrial(new Trial(new RandomInputGenerator().genRandomInts()));
    }
}
