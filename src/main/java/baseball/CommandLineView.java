package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandLineView implements View {

    @Override
    public void askToPutNumber() {
        System.out.print("숫자를 입력해주세요 : ");;
    }

    @Override
    public void winTheGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private List<String> scoreToStringList(Map<Score.ScoreEnum, Integer> scoreMap) {
        final List<String> scoreList = new ArrayList<>();
        if (scoreMap.get(Score.ScoreEnum.BALL) != null) {
            scoreList.add(scoreMap.get(Score.ScoreEnum.BALL) + Score.ScoreEnum.BALL.getName());
        }
        if (scoreMap.get(Score.ScoreEnum.STRIKE) != null) {
            scoreList.add(scoreMap.get(Score.ScoreEnum.STRIKE) + Score.ScoreEnum.STRIKE.getName());
        }
        return scoreList;
    }

    @Override
    public void score(Score score) {
        if (score.isAllNothing()) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(String.join(" ", scoreToStringList(score.scoreMap())));
    }

    @Override
    public void dashboard() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
