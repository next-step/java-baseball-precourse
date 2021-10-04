package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        PlayGround playGround = new PlayGround();
        playGround.setComputerTrial(new Trial(genRandomInts()));

        boolean isContinuePlaying = true;
        while (isContinuePlaying) {
            System.out.println("숫자를 입력해주세요: ");

            String input = Console.readLine();

            ArrayList<Integer> inputBallNumbers;

            try {
                inputBallNumbers = new InputParser().parse(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 입력한 값이 유효하지 않습니다. 1~9 사이의 정수값 3개를 입력해주세요...");
                continue;
            }

            boolean isGameEnd = playGround.run(new Trial(inputBallNumbers));

            playGround.printPlayResult();

            if (isGameEnd) {
                System.out.println("3개의 숫자를 모두 맞추셨습니다!");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                input = Console.readLine();

                if (input.equals("1")) {
                    System.out.println("게임 끝");

                    playGround.setComputerTrial(new Trial(genRandomInts()));
                }

                if (input.equals("2")) {
                    isContinuePlaying = false;
                }
            }
        }
    }

    private static ArrayList<Integer> genRandomInts() {
        ArrayList<Integer> randomInts = new ArrayList<>();

        while (randomInts.size() < 3) {
            int randomInt = Randoms.pickNumberInRange(1, 9);

            if (randomInts.contains(randomInt)) {
                continue;
            }

            randomInts.add(randomInt);
        }
        return randomInts;
    }
}
