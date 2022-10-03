package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameHandler {
    BaseballGame mBbGame;

    public BaseballGameHandler() {
        mBbGame = new BaseballGame();
        setNewGame();
    }

    public boolean setNewGame() {
        mBbGame.setRandomNumber();
        return true;
    }

    public boolean inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        int res[] = mBbGame.inputCompareNumber(inputNum);
        int strike = res[0];
        int ball = res[1];
        printResult(strike, ball);
        if (!processThreeStrike(strike))
            return false;

        return true;
    }

    private int getInputResult() {
        String input = Console.readLine();
        if (input.length() != 1)
            throw new IllegalArgumentException("입력이 잘못되었습니다. -> " + input);

        char c = input.charAt(0);
        if (!((c == 0x31) || (c == 0x32)))
            throw new IllegalArgumentException("입력이 잘못되었습니다. -> " + input);

        return (int) c & 0x0f;
    }

    private int requestRegame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return getInputResult();
    }

    private boolean processThreeStrike(int strike) {
        if (strike != 3) return true;

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        int resNum = requestRegame();
        if (resNum != 1) return false;

        setNewGame();
        return true;
    }

    private void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball != 0)
            System.out.print(ball + "볼 ");
        if (strike != 0)
            System.out.print(strike + "스트라이크");
        System.out.println();
    }
}
