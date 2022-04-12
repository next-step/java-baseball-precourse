package baseball;

import baseball.game.Play;
import baseball.model.Board;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Board board = new Board();
        Play play = new Play();
        play.initGoal(board);

        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            String input = Console.readLine();

            play.validInput(input);
            play.writeScore(board, input);
            System.out.println(play.printResult(board));

            if (board.getScore()[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");

                if (Integer.parseInt(Console.readLine()) == 1) {
                    play.initGoal(board);
                    continue;
                }
                break;
            }
        }
    }
}
