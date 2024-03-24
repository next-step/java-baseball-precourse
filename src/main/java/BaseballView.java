import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BaseballView {
    private final Scanner scanner;
    private final String INPUT_MESSAGE = "숫자를 입력해주세요: ";
    private final String ERROR_MESSAGE = "[ERROR] 잘못된 값을 입력하셨습니다.";
    private final String WIN_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 끝\n";
    private final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private final String END_STRING = "2";
    private static final Pattern GAME_END_REGEX = Pattern.compile("^[1-2]$");

    BaseballView() {
        scanner = new Scanner(System.in);
    }

    String inputUserNumber() {
        System.out.print(INPUT_MESSAGE);
        String userNumber = scanner.nextLine();

        return userNumber;
    }

    // [lo, hi] 범위의 정수가 length개 있는지 판별
    boolean validateUserNumber(String userNumber, int length, int lo, int hi) {
        String pattern = String.format("^[%d-%d]{%d}$", lo, hi, length);
        return userNumber.matches(pattern);
    }

    int[] refineUserNumber(String userNumber) {
        int length = userNumber.length();
        int[] userNumbers = new int[length];
        for (int i = 0; i < length; i++) {
            userNumbers[i] = userNumber.charAt(i) - '0';
        }
        return userNumbers;
    }

    void printResult(BaseballScore score) {
        List<String> messageList = new ArrayList<>();
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();
        if (score.hasStrike()) {
            messageList.add(strikeCount + "스트라이크");
        }
        if (score.hasBall()) {
            messageList.add(ballCount + "볼");
        }
        String message = String.join(" ", messageList);
        if (score.isNothing()) {
            message = "낫싱";
        }
        System.out.println(message);
    }

    void printError() {
        System.out.println(ERROR_MESSAGE);
    }

    void printWinMessage(int length) {
        System.out.printf(WIN_MESSAGE, length);
    }

    void printContinueMessage() {
        System.out.println(CONTINUE_MESSAGE);
    }

    boolean askGameEnd() {
        String gameEnd;
        while (true) {
            printContinueMessage();
            gameEnd = scanner.nextLine();
            if(validateGameEnd(gameEnd)){
                break;
            }
            printError();
        }

        return gameEnd.equals(END_STRING);
    }

    boolean validateGameEnd(String gameEnd) {
        return GAME_END_REGEX.matcher(gameEnd).matches();
    }
}
