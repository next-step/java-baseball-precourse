package baseball.service;

import baseball.exception.GameException;
import nextstep.utils.Console;
import baseball.util.Constant;

public class Game {
    private static final Game GAME = new Game();

    private Game(){}

    public static Game getGameInstance() {
        return GAME;
    }

    // 사용자가 문제 맞추는 메소드
    public void play(String number){
        Score score = Score.getInstance();
        String input = "";
        do {
            input = getInputNumber();
        } while (!checkInputNumber(input, Constant.NUMBER_SIZE, Constant.NUMBER_LOW, Constant.NUMBER_HIGH) || !score.checkScore(number, input));
    }

    // 게임 계속할지 여부 확인 (1이면 true 반환하여 계속 진행)
    public boolean isEndFromInput() {
        String input = "";
        do {
            input = getInputEnd();
        } while(!checkInputNumber(input, Constant.END_MESSAGE_LENGTH, Constant.END_MESSAGE_LOW, Constant.END_MESSAGE_HIGH));

        return input.charAt(0)-'0' == Constant.CONTINUE_GAME;
    }

    // 사용자 input - 숫자 입력
    private String getInputNumber() {
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    // 사용자 input - 종료 여부 입력
    private String getInputEnd() {
        System.out.println(String.format("게임을 새로 시작하시려면 %d, 종료하려면 %d를 입력하세요.", Constant.CONTINUE_GAME, Constant.END_GAME));
        return Console.readLine();
    }

    // 예외 확인을 위한 함수
    private boolean checkInputNumber(String input, int length, int low, int high) {
        try {
            isOnlyNum(input);
            isMatchLength(input, length);
            isInScope(input, low, high);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    // 예외 확인 메소드1 - 숫자 검사
    private void isOnlyNum(String input) throws GameException {
        if (!input.matches("[0-9]+")) {
            throw new GameException("[ERROR] 숫자 이외의 문자는 입력할 수 없습니다.");
        }
    }

    // 예외 확인 메소드2 - 길이 검사
    private void isMatchLength(String input, int length) throws GameException {
        if (input.length() != length) {
            throw new GameException(String.format("[ERROR] %d자리 숫자로 입력해 주십시오.", length));
        }
    }

    // 예외 확인 메소드3 - 범위 검사
    private void isInScope(String input, int low, int high) throws GameException {
        for (int i = 0; i < input.length(); i++) {
            isInScopeByChar(input.charAt(i), low, high);
        }
    }

    private void isInScopeByChar(char c, int low, int high) throws GameException {
        if (c-'0' < low || c-'0' > high) {
            throw new GameException(String.format("[ERROR] %d부터 %d까지 입력 가능합니다.", low, high));
        }
    }
}
