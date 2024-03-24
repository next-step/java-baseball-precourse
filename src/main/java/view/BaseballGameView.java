package view;

import java.util.Scanner;

public class BaseballGameView {
    private final Scanner scanner;

    public BaseballGameView() {
        scanner = new Scanner(System.in);
    }

    public int[] getUserNumbers() {
        System.out.print("세 자리 정수를 입력하세요: ");
        int[] userNumbers = new int[3];
        String input = scanner.nextLine();

        if (checkInputNumber(input)) {
            for (int i = 0; i < 3; i++) {
                userNumbers[i] = input.charAt(i) - '0';
            }
            return userNumbers;
        }

        System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");
        return getUserNumbers();
    }

    private static boolean checkInputNumber(String input) {
        return input.matches("[1-9]{3}");
    }

    public void displayResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
            return;
        }

        if (result[0] != 0) {
            System.out.print(result[0] + "스트라이크 ");
        }

        if (result[1] != 0) {
            System.out.print(result[1] + "볼");
        }

        System.out.println();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getNextLine() {
        return scanner.nextLine();
    }
}
