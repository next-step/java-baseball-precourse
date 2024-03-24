package view;

import exception.GameException;
import model.GameResult;

import java.util.Scanner;

public class GameView {

    private Scanner scanner;

    public GameView() {
        resetScanner();
    }

    private void resetScanner() {
        scanner = new Scanner(System.in);
    }

    public UserCommand getUserCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        try {
            return UserCommand.of(scanner.nextInt());
        } catch (Exception e) {
            resetScanner();
            throw new GameException(e);
        }
    }

    public int getUserInput() {
        System.out.println("숫자를 입력해주세요: ");

        try {
            return scanner.nextInt();
        } catch (Exception e) {
            resetScanner();
            throw new GameException(e);
        }
    }

    public void printResult(GameResult result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder sb = new StringBuilder();

        if (result.getStrikeCount() > 0) {
            sb.append(String.format("%d스트라이크", result.getStrikeCount()));
        }

        if (result.getBallCount() > 0) {
            if (result.getStrikeCount() > 0) {
                sb.append(" ");
            }
            sb.append(String.format("%d볼", result.getBallCount()));
        }

        System.out.println(sb);

        if (result.isOver()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        }
    }
}
