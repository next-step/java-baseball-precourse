package ui;

import domain.Baseball;
import domain.Numbers;
import domain.Result;

import java.util.*;

public class BaseballGame {

    public static void startGame(int size) {
        Baseball baseball = new Baseball(size);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            baseball.startGame();
            guessNumbers(baseball, scanner, size);
            NextGame token = getNextGameInput(scanner);
            if (token == NextGame.End) {
                break;
            }
        }
    }

    private static void guessNumbers(Baseball baseball, Scanner scanner, int size) {
        while (true) {
            Numbers input = getGuessNumsInput(scanner, size);
            Result result = baseball.guessNumbers(input);
            printResult(result);

            if (result.isSuccess(size)) {
                System.out.println("3개의 숫자를 모듀 맞히셨습니다! 게임 끝");
                break;
            }
        }
    }

    private static Numbers getGuessNumsInput(Scanner scanner, int size) {
        List<Integer> nums = getIntArray(scanner, size, "숫자를 입력해주세요 : ");
        return new Numbers(nums);
    }

    private static NextGame getNextGameInput(Scanner scanner) {
        while (true) {
            try {
                List<Integer> nums = getIntArray(scanner, 1, "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                return NextGame.of(nums.get(0));
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static List<Integer> getIntArray(Scanner scanner, int size, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return getIntArray(scanner, size);
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static List<Integer> getIntArray(Scanner scanner, int size) throws RuntimeException {
        StringTokenizer tokens = new StringTokenizer(scanner.nextLine());
        List<Integer> nums = new ArrayList<>(size);
        while (tokens.hasMoreTokens()) {
            nums.add(Integer.parseInt(tokens.nextToken()));
        }
        if (nums.size() != size) {
            throw new RuntimeException(size + "개의 숫자를 입력해야 합니다 (입력 개수: " + nums.size() + ")");
        }
        return nums;
    }

    private static void printResult(Result result) {
        if (result.getStrikes() == 0 && result.getBalls() == 0) {
            System.out.println("낫싱");
            return;
        }
        StringBuilder builder = new StringBuilder();
        if (result.getStrikes() > 0) {
            builder.append(result.getStrikes());
            builder.append("스트라이크 ");
        }
        if (result.getBalls() > 0) {
            builder.append(result.getBalls());
            builder.append("볼");
        }
        System.out.println(builder);
    }

}
