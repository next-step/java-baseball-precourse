package baseball;

public class GameConsoleView {
    public static int boolToInt(boolean bool) {
        return bool ? 1 : 0;
    }

    public static int[] resultsToStrikeBallCountArray(GameResult[] gameResults) {
        int[] resultArray = new int[2];
        for (GameResult gameResult : gameResults) {
            resultArray[0] += boolToInt(gameResult == GameResult.BALL);
            resultArray[1] += boolToInt(gameResult == GameResult.STRIKE);
        }
        return resultArray;
    }

    public static void printInputRequired() {
        System.out.println("숫자를 입력해주세요: ");
    }

    public static int sum(int[] arr) {
        int result = 0;
        for (int j : arr) {
            result += j;
        }
        return result;
    }

    public static void printInputResult(GameResult[] gameResults) {
        String resultString = "";
        int[] countArray = resultsToStrikeBallCountArray(gameResults);
        int ballCount = countArray[0];
        int strikeCount = countArray[1];
        if (sum(countArray) == 0) {
            System.out.println("낫싱");
            return;
        }
        resultString += ballCount > 0 ? String.format("%d볼", ballCount) : "";
        resultString += strikeCount > 0 ? String.format(" %d스트라이크", strikeCount) : "";
        System.out.println(resultString.trim());
    }

    public static void printSuccessMessage() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", Config.GAME_COUNT);
    }

    public static void printContinueAskInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printGameFinished() {
        System.out.println("게임 종료");
    }
}
