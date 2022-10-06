package baseball;

import baseball.controller.Controller;
import baseball.model.Computer;
import baseball.util.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class Application {
    private static boolean shouldContinue = true;
    private static Computer computer;
    private static final int DEFAULT_SIZE = 3;

    public static void main(String[] args) {
        gameStart();
    }

    private static void gameStart() {
        computer = new Computer();
        do {
            String userInput = Console.readLine();
            checkValidation(userInput);
            Map<String, Integer> result = Controller.getCompareResultByInput(computer, userInput);
            checkGameResult(result);
        } while (shouldContinue);
    }

    private static void checkGameResult(Map<String, Integer> result) {
        if (result.get("strike") == DEFAULT_SIZE) {
            System.out.println(DEFAULT_SIZE + "스트라이크");
            System.out.println(DEFAULT_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            shouldGameRestart();
            return;
        }
        printOutResult(result);
    }

    private static void shouldGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String userInput = Console.readLine();
        if (userInput.equals("2")) {
            shouldContinue = false;
            System.out.println("게임 종료");
            return;
        }
        computer = new Computer();
        shouldContinue = true;
    }

    private static void printOutResult(Map<String, Integer> result) {
        if (result.get("ball") > 0) {
            System.out.print(result.get("ball") + "볼 ");
        }
        if (result.get("strike") > 0) {
            System.out.print(result.get("strike") + "스트라이크 ");
        }
        if (result.get("nothing") > 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    private static void checkValidation(String userInput) {
        new Validation(DEFAULT_SIZE).validateInputData(userInput);
    }
}
