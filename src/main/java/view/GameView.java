package view;

import model.Score;

import java.util.Scanner;

public class GameView {
    private final Scanner sc = new Scanner(System.in);

    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return sc.nextLine();
    }

    public void displayScore(Score score) {
        String msg = getScore(score);
        System.out.println(msg);
    }

    public String getScore(Score score) {
        int strikes = score.getStrikes();
        int balls = score.getBalls();

        if (strikes == 3) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
        }

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }

        return formatScoreMessage(strikes, balls);
    }


    private String formatScoreMessage(int strikes, int balls) {
        StringBuilder result = new StringBuilder();
        if (strikes > 0) {
            result.append(strikes).append("스트라이크 ");
        }

        if (balls > 0) {
            result.append(balls).append("볼 ");
        }
        
        return result.toString().trim();
    }

    public String askForNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        return sc.nextLine();
    }

    public void displayError(String error) {
        System.out.println("[ERROR]" + error);
    }
}