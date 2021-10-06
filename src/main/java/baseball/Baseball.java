package baseball;

import nextstep.utils.Console;

public class Baseball {
    private boolean running = true;

    public boolean isRunning() {
        return this.running;
    }

    public void run() {
        Number targetNumber = new Number(TargetNumberProvider.generate());

        while (true) {
            Number expectedNumber = getExpectedNumber();
            char[] chars = expectedNumber.getValue().toCharArray();
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                int index = targetNumber.getValue().indexOf(aChar);
                if (index < 0) continue;
                if (index == i) {
                    strike++;
                } else {
                    ball++;
                }

            }
            Result result = new Result(strike, ball);
            System.out.println(result.getMessage());
            if (result.isCorrect()) break;
        }

        changeRunningStatus(getNextCommand());
    }

    private Number getExpectedNumber() {
        while (true) {
            try {
                System.out.println("숫자를 입력해주세요 : ");
                return new Number(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Command getNextCommand() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Command.of(Console.readLine());
    }

    private void changeRunningStatus(Command command) {
        if (command == Command.EXIT) this.running = false;
    }
}