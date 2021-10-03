package baseball;

import static nextstep.utils.Console.readInt;

public class Game {
    public static final int RESTART_NUMBER = 1;
    public static final int EXIT_NUMBER = 2;

    private final Baseball baseball = new Baseball();

    public void start() {
        System.out.println("게임을 시작합니다.");

        // 초기 설정
        setUp();

        // 정답 맞추기 시도
        guessAnswerRepeat();
        System.out.println("3개의숫자를모두맞히셨습니다!게임끝");

        // 종료 여부 확인
        askExitGameRepeat();

        System.out.println("게임을 종료합니다.");
    }

    private void setUp() {
        baseball.generateAnswer();
    }

    private void guessAnswerRepeat() {
        boolean answerFlag = false;
        while (!answerFlag) {
            answerFlag = guessAnswer();
        }
    }

    private boolean guessAnswer() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            int tryNumber = readInt();
            BallCount ballCount = baseball.guessAnswer(tryNumber);
            System.out.println(ballCount);
            return ballCount.isThreeStrike();
        } catch (RuntimeException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return false;
        }
    }

    private void askExitGameRepeat() {
        Boolean exitFlag = null;
        while (exitFlag == null) {
            try {
                System.out.println("게임을 새로 시작하려면 " + RESTART_NUMBER + ", 종료하려면 " + EXIT_NUMBER + "를 입력하세요.");
                exitFlag = askExitGame();
            } catch (RuntimeException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        if (!exitFlag) {
            start();
        }
    }

    private boolean askExitGame() {
        int d = readInt();
        if (d == EXIT_NUMBER) {
            return true;
        }
        if (d == RESTART_NUMBER) {
            return false;
        }
        throw new RuntimeException("잘못된 숫자 기입");
    }
}
