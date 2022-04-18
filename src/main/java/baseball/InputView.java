package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class InputView {

    static final int START = 1;
    static final int STOP = 2;
    private static final String GAME_PLAYER_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ALL_STRIKE_RESTART_MESSAGE = "3개의 숫자를 모두 맞히셨습니다. 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputView() {
    }

    public static int inputGamePlayerNumber() {
        System.out.print(GAME_PLAYER_NUMBER_INPUT_MESSAGE);
        return getGamePlayerNumber();
    }

    public static int inputRestartNumber() {
        System.out.println(ALL_STRIKE_RESTART_MESSAGE);
        System.out.println(RESTART_MESSAGE);
        return getGamePlayerSystemNumber();
    }

    private static int getGamePlayerSystemNumber() {
        String gamePlayerSystemValue = Console.readLine();
        if (!validGamePlayerSystemNumber(gamePlayerSystemValue.split(""))) {
            throw new IllegalArgumentException("입력한 숫자가 1 또는 2가 아닙니다.");
        }
        return Integer.parseInt(gamePlayerSystemValue);
    }

    private static boolean validGamePlayerSystemNumber(String[] gamePlayerSystemNumberArray) {
        if (gamePlayerSystemNumberArray.length != 1) return false; // 1자리 인지
        int systemNumber = 0;
        for (String number : gamePlayerSystemNumberArray) {
            if (!number.matches("[+]?\\d*(\\.\\d+)?")) return false; // 숫자로 되어 있는지
            systemNumber = Integer.parseInt(number);
        }
        if (systemNumber != START && systemNumber != STOP) return false; // RESTART(1) 과 STOP(2) 아니면
        return systemNumber == START || systemNumber == STOP;
    }

    private static int getGamePlayerNumber() {
        String gamePlayerNumber = Console.readLine();
        if (!validGamePlayerNumber(gamePlayerNumber.split(""))) {
            throw new IllegalArgumentException("입력한 숫자가 3자리 인지, 1~9사이 수인지, 중복된 것이 있는지 확인이 필요합니다.");
        }
        return Integer.parseInt(gamePlayerNumber);
    }

    private static boolean validGamePlayerNumber(String[] gamePlayerNumberArray) {
        if (gamePlayerNumberArray.length != 3) return false; // 3자리 인지
        Set<String> gamePlayerNumberSet = new HashSet<>();
        for (String number : gamePlayerNumberArray) { // 1~9 사이의 숫자로 각 자리가 되어 있는지
            if (!number.matches("[+]?\\d*(\\.\\d+)?")) return false;
            gamePlayerNumberSet.add(number);
        }
        if (gamePlayerNumberSet.size() != 3) return false; // 각 자리가 중복되는 것이 있는지
        return true;
    }
}
