package baseball;

import java.util.List;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        boolean isContinue = true;
        BaseballGame baseballGame = new BaseballGame();
        List<Integer> pitcher = null;
        while(isContinue) {
            if (pitcher == null) {
                pitcher = baseballGame.pitcher();
            }
            List<Integer> swing = baseballGame.swing();
            BaseBall baseBall = baseballGame.run(pitcher, swing);
            boolean result = baseballGame.result(baseBall);
            if (result == true) {
                System.out.println("게임을 새로 시작하려면 1, 종료하라면 2를 입력하세요.");
                String menuStr = Console.readLine();
                if ("2".equals(menuStr)) {
                    isContinue = false;
                }
                // 새 게임
                pitcher = baseballGame.pitcher();
            }
        }
    }
}
