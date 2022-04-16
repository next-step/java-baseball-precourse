package baseball.service;

import baseball.dto.BaseballDto;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.constants.BaseballConstants.END_CODE;
import static baseball.constants.BaseballConstants.START_CODE;

public class ConsoleService {
    ConsoleService() {
        throw new IllegalArgumentException("Utility class");
    }

    /**
     * 숫자 입력 메시지 출력
     * @return
     * @throws IllegalArgumentException
     */
    public static String doInputNumber() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        if (!validNumber(inputNumber)) {
            throw new IllegalArgumentException("입력 값을 확인하세요.");
        }

        return inputNumber;
    }

    private static boolean validNumber(String inputNumber) {
        if(!isNumber(inputNumber)) {
            return false;
        } else if (inputNumber.length() != 3) {
            return false;
        } else if(isDuplicatedEachNumber(inputNumber)) {
            return false;
        }

        return true;
    }

    private static boolean isNumber(String inputNumber) {
        try {
            Integer.valueOf(inputNumber);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private static boolean isDuplicatedEachNumber(String inputNumber) {
        char[] eachNumbers = inputNumber.toCharArray();
        Set<Character> set = new HashSet();

        for(int i = 0; i < eachNumbers.length; i++) {
            set.add(eachNumbers[i]);
        }

        return set.size() != 3;
    }

    /**
     * 게임 스코어 출력
     * @param baseball 스코어
     */
    public static void printGameScore(BaseballDto baseball) {
        printStrikeAndBall(baseball);

        if(baseball.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static void printStrikeAndBall(BaseballDto baseball) {
        StringBuilder result = new StringBuilder();

        if(baseball.getBall() > 0)
            result.append(String.format("%d볼 ", baseball.getBall()));
        if(baseball.getStrike() > 0)
            result.append(String.format("%d스트라이크", baseball.getStrike()));
        if(Strings.isNullOrEmpty(result.toString()))
            result.append("낫싱");

        System.out.println(result);
    }

    /**
     * 새로운 게임 메시지 및 입력
     * @return
     */
    public static String doInputGameCode() {
        System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
        String startCode =  Console.readLine();

        if (!validStartCode(startCode)) {
            throw new IllegalArgumentException("입력 값을 확인하세요.");
        }

        return startCode;
    }

    private static boolean validStartCode(String startCode) {
        if(!isNumber(startCode)) {
            return false;
        } else if (!Arrays.asList(START_CODE, END_CODE).contains(startCode)) {
            return false;
        }

        return true;
    }
}
