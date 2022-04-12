package baseball.game;

import baseball.model.Board;
import camp.nextstep.edu.missionutils.Randoms;

public class Play {

    public void validInput(String input) {
        if (input.length() > 3 || input.length() < 3) {
            throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다.");
        }
    }

    public void initGoal(Board board) {
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Randoms.pickNumberInRange(1, 9);;
        }
        board.setGoal(arr);
    }

    public void writeScore(Board board, String input) {
        String[] tmp = input.split("");
        int[] score = new int[2];
        for (int i = 0; i < 3; i++) {
            int result = checkNum(board.getGoal(), Integer.parseInt(tmp[i]), i);
            if (result == 1) {
                score[1]++;
                continue;
            }
            if (result == 2) {
                score[0]++;
                continue;
            }
        }
        board.setScore(score);
    }

    private int checkNum(int[] goal, int num, int index) {
        if (goal[index] == num) {
            return 1;
        }

        for (int i = 0; i < 3; i++) {
            if (goal[i] == num) {
                return 2;
            }
        }

        return 3;
    }

    public String printResult(Board board) {
        StringBuilder sb = new StringBuilder();

        if (board.getScore()[0] == 0 && board.getScore()[1] == 0) {
            return "낫싱";
        }
        if (board.getScore()[0] > 0) {
            sb.append(board.getScore()[0]).append("볼 ");
        }
        if (board.getScore()[1] > 0) {
            sb.append(board.getScore()[1]).append("스트라이크");
        }
        return sb.toString();
    }
}
