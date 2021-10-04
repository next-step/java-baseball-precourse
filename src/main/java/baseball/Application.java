package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.ArrayList;

public class Application {

    public static final String SUCCESS_MSG = "3개의 숫자를 모두 맞추셨습니다!";
    public static final String REGAME_REQUEST_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_FINISHED_MSG = "게임 끝";
    public static final String INPUT_ERROR_MSG = "[ERROR] 입력한 값이 유효하지 않습니다. 1~9 사이의 정수값 3개를 입력해주세요...";
    public static final String REQUEST_INPUT_MSG = "숫자를 입력해주세요: ";
    public static final String WANT_REGAME_MSG = "1";
    public static final String DO_NOT_WANT_REGAME_MSG = "2";
    public static final String NEW_LINE = "\n";

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
            System.out.println(INPUT_ERROR_MSG);

            return new ArrayList<>();
        }
    }

    private static boolean proceedGame(ArrayList<Integer> inputBallNumbers) {
        if (inputBallNumbers.size() == 0) return true;

        boolean isGameEnd = playGround.run(new Trial(inputBallNumbers));

        return isGameEnd ? afterGameEnd() : true;
    }

    private static boolean afterGameEnd() {
        System.out.println(SUCCESS_MSG + NEW_LINE + REGAME_REQUEST_MSG);

        String input = Console.readLine();

        if (input.equals(WANT_REGAME_MSG)) {
            System.out.println(GAME_FINISHED_MSG);

            standByGame();
        }

        return input.equals(DO_NOT_WANT_REGAME_MSG) ? false : true;
    }

    private static void standByGame() {
        if (playGround == null) {
            playGround = new PlayGround();
        }

        playGround.setComputerTrial(new Trial(genRandomInts()));
    }

    private static ArrayList<Integer> genRandomInts() {
        ArrayList<Integer> randomInts = new ArrayList<>();

        while (randomInts.size() < GlobalVariables.MAX_BALL_CNT) {
            int randomInt = Randoms.pickNumberInRange(GlobalVariables.MIN_BALL_NUMBER, GlobalVariables.MAX_BALL_NUMBER);

            insertOnlyDistinct(randomInts, randomInt);
        }

        return randomInts;
    }

    private static void insertOnlyDistinct(ArrayList<Integer> into, int insertValue) {
        if (into.contains(insertValue)) return;

        into.add(insertValue);
    }
}
