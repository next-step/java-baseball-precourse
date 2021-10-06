package baseball;

import nextstep.utils.Console;

class GameUI {

    static void printNumberInputRequest() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    static String userInput() {
        return Console.readLine();
    }

    static void printInvalidInputErrorMessage() {
        System.out.println("[ERROR] 잘못된 사용자 입력 입니다.");
    }

    static void printNothing() {
        System.out.println("낫싱");
    }

    static void printAllMatchMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    static void printAskRetryMessage() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
    }

    static boolean isRetryNeeded(String retryInput) {
        return "1".equals(retryInput);
    }

    static void printGrade(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            System.out.println(strikeCount + "스트라이크 " + ballCount + "볼");
            return;
        }

        if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }

        System.out.println(ballCount + "볼");
    }
}
