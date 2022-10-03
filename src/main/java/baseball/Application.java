package baseball;

import baseball.domain.Board;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        Board computerBoard = new Board();

        String gameResult = "";
        String inputStringLine = "";
        while(!gameResult.equals("3스트라이크")) {
            System.out.print("숫자를 입력해 주세요 : ");
            inputStringLine = Console.readLine();
            Board userBoard = new Board(inputStringLine);
            gameResult = computerBoard.compareBoard(userBoard).getResultString();
            System.out.println(gameResult);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        exitGame();
    }

    public static void exitGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            startGame();
        } else if(input.equals("2")) {
            return;
        }
    }
}
