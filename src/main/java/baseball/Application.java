package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String pickedRandomNumber = getRandomNumber();
        playBaseball(pickedRandomNumber);
    }

    public static String getRandomNumber() {
        StringBuilder result = new StringBuilder();
        while (result.length() < 3) {
            String newNumber = Integer.toString(pickNumberInRange(1, 9));
            if (!result.toString().contains(newNumber)) {
                result.append(newNumber);
            }
        }
        return result.toString();
    }



    public static String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public static void checkInput(String input) {
        if (checkLength(input) || checkDigit(input)) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }

    private static boolean checkLength(String input) {
        return input.length() != 3;
    }

    private static boolean checkDigit(String input) {
        for (int i = 0; i < 3; i++) {
            char now = input.charAt(i);
            if (!Character.isDigit(now) || Character.getNumericValue(now) <= 0) {
                return true;
            }
        }
        return false;
    }

    private static int getStrikeCount(String input, String randomNumber) {
        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            if (input.charAt(index) == randomNumber.charAt(index)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    private static int getBallCount(String input, String randomNumber) {
        int ballCount = 0;
        for (int index = 0; index < 3; index++) {
            char now = input.charAt(index);
            if (randomNumber.contains(Character.toString(now)) && (randomNumber.charAt(index) != now)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    private static boolean get3Strike(String input, String randomNumber) {
        int strikeCount = getStrikeCount(input, randomNumber);
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    public static void getStringResult(String input, String randomNumber) {
        int ballCount = getBallCount(input, randomNumber);
        int strikeCount = getStrikeCount(input, randomNumber);
        String result = "";
        result += getResultString(ballCount, "볼");
        result += getResultString(strikeCount, "스트라이크");
        if (result.length() == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(result);
    }

    private static String getResultString(int count, String type) {
        if (count > 0) {
            return String.format("%d%s ", count, type);
        }
        return "";
    }

    private static void playBaseball(String randNumber) {
        while (true) {
            String input = getInput();
            checkInput(input);
            getStringResult(input, randNumber);
            if (get3Strike(input, randNumber)) {
                if (!getContinue()) {
                    return;
                }
                randNumber = getRandomNumber();
            }
        }
    }

    private static boolean getContinue() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = readLine();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
