package view;

import camp.nextstep.edu.missionutils.Console;
import domain.EvaluatedResult;
import domain.Result;

import static domain.constant.Constant.*;

public class GameConsoleView {
    public static void printInputInstruction() {
        System.out.print(INPUT_REQUEST_INSTRUCTION);
    }

    public static String getInput() {
        return Console.readLine();
    }

    public static void printHint(EvaluatedResult evaluatedResult) {
        Result result = evaluatedResult.getResult();
        int strike = result.getStrike();
        int ball = result.getBall();
        if(strike == 0 && ball == 0) {
            System.out.print(NOTHING_MESSAGE);
        }
        if(ball != 0) {
            System.out.print(ball + BALL_MESSAGE);
        }
        if(strike != 0) {
            System.out.print(strike + STRIKE_MESSAGE);
        }

        System.out.println();

        if (strike == 3) {
            System.out.println(WIN_MESSAGE);
        }
    }

    public static boolean requestRestart() {
        System.out.println(RESTART_REQUEST_INSTRUCTION);
        String restartInput = getInput();
        if(restartInput.equals(RESTART)) return true;
        if(restartInput.equals(QUIT)) return false;
        throw new IllegalArgumentException(RESTART_VALUE_VALIDATION_EXCEPTION);
    }
}
