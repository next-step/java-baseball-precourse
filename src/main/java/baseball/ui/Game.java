package baseball.ui;

import baseball.balls.Ball;
import baseball.balls.Balls;
import baseball.gameresult.GameResult;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.*;

public class Game {

    private final static String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    private final static String GAME_RESTART_QUESTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final static String RESTART_GAME_NUMBER = "1";
    private final static String END_GAME_NUMBER = "2";

    public static int start() {
        Balls computerBalls = createComputerBalls();

        boolean isEnd = false;

        while (!isEnd) {
            Balls userBalls = inputUserBall();

            GameResult gameResult = new GameResult(computerBalls, userBalls);

            String resultMessage = gameResult.getResultMessage();

            isEnd = gameResult.isEnd();

            System.out.print(resultMessage + "\n");
        }

        return gameEnd();
    }

    private static int gameEnd() {
        System.out.print(GAME_END_MESSAGE + "\n");

        System.out.print(GAME_RESTART_QUESTION_MESSAGE);

        String restartNumber = Console.readLine();

        if (restartNumber.equals(RESTART_GAME_NUMBER)) {
            start();
            return Integer.parseInt(RESTART_GAME_NUMBER);
        }

        if (restartNumber.equals(END_GAME_NUMBER)) {
            return Integer.parseInt(END_GAME_NUMBER);
        }

        return Integer.parseInt(RESTART_GAME_NUMBER);
    }


    private static Balls createComputerBalls() {
        List<Ball> ballList = new ArrayList<>();
        List<Integer> ballNumberList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            notDuplicateBallCreate(ballList, ballNumberList, i);
        }

        Balls computerBalls = new Balls(ballList);

        return computerBalls;
    }

    private static void notDuplicateBallCreate(List<Ball> ballList, List<Integer> ballNumberList, int index) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        while (!ballNumberList.contains(randomNumber)) {
            ballNumberList.add(randomNumber);
            createBall(ballList, index, randomNumber);
        }
    }

    private static void createBall(List<Ball> ballList, int index, int randomNumber) {
        ballList.add(new Ball(index, randomNumber));
    }

    public static Balls inputUserBall() {
        System.out.print(INPUT_NUMBER_MESSAGE);

        String userInputValue = Console.readLine();

        Balls userBalls = createUserBalls(userInputValue);

        return userBalls;
    }


    private static Balls createUserBalls(String inputNumber) {
        List<Ball> ballList = new ArrayList<>();

        List<String> splitUserBallList = Arrays.asList(inputNumber.split(""));

        for (int i = 0; i < splitUserBallList.size(); i++) {
            int parsingNumber = Integer.parseInt(splitUserBallList.get(i));
            ballList.add(new Ball(i + 1, parsingNumber));
        }

        return new Balls(ballList);
    }


}
