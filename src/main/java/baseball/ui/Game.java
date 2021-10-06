package baseball.ui;

import baseball.balls.Ball;
import baseball.balls.Balls;
import baseball.gameresult.GameResult;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    final static String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";


    public static void gameStart() {
        Balls computerBalls = createComputerBalls();

        System.out.printf(INPUT_NUMBER_MESSAGE);

        String userInputValue = Console.readLine();

        Balls userBalls = createUserBalls(userInputValue);

        GameResult gameResult = new GameResult(computerBalls, userBalls);

        gameResult.playGame();

        System.out.println("gameResult.playGame()" + gameResult.playGame());
    }

    private static Balls createComputerBalls() {

        List<Ball> ballList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            System.out.println("randomNumber" + randomNumber);

            ballList.add(new Ball(i, randomNumber));
        }

        Balls computerBalls = new Balls(ballList);

        return computerBalls;
    }

    private static Balls createUserBalls(String inputNumber) {
        List<Ball> ballList = new ArrayList<>();

        List<String> splitUserBallList = Arrays.asList(inputNumber.split(""));

        for (int i = 0; i < splitUserBallList.size(); i++) {
            int parsingNumber = Integer.parseInt(splitUserBallList.get(i));
            ballList.add(new Ball(i + 1, parsingNumber));
        }

        Balls userBalls = new Balls(ballList);

        return userBalls;
    }


}
