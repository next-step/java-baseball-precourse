package baseball;

import nextstep.utils.Console;

public class Baseball {
    private boolean runnable = true;

    public boolean isRunnable() {
        return this.runnable;
    }

    public void run() {
        if (!isRunnable()) return;

        Number answerNumber = new Number(RandomNumberProvider.generate());

        while (true) {
            Result result = compute(answerNumber, getGuessNumber());
            print(result.getMessage());
            if (result.isCorrect()) break;
        }

        decideTerminateStatus(getNextCommand());
    }

    private Number getGuessNumber() {
        while (true) {
            try {
                print("숫자를 입력해주세요 : ");
                return new Number(Console.readLine());
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
        }
    }

    private Result compute(Number targetNumber, Number guessNumber) {
        char[] guessNumbers = guessNumber.getValue().toCharArray();
        int strike = 0;
        int ball = 0;
        for (int currentIndex = 0; currentIndex < guessNumbers.length; currentIndex++) {
            int foundIndex = targetNumber.getValue().indexOf(guessNumbers[currentIndex]);
            if (foundIndex < 0) continue;
            if (foundIndex == currentIndex) {
                strike++;
            } else {
                ball++;
            }
        }
        return new Result(strike, ball);
    }

    private Command getNextCommand() {
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Command.of(Console.readLine());
    }

    private void decideTerminateStatus(Command command) {
        if (command == Command.EXIT) this.runnable = false;
    }

    private void print(String message) {
        System.out.println(message);
    }
}