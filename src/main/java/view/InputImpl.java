package view;

import java.util.Scanner;

public class InputImpl implements Input{

    @Override
    public int endInput() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(input);
        return input;
    }

    @Override
    public String baseballInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();
        return input;
    }
}
