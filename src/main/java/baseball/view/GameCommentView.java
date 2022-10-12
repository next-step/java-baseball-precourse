package baseball.view;

import baseball.vo.GameResultStatus;
import camp.nextstep.edu.missionutils.Console;

public class GameCommentView {

    private final String inputText = "숫자를 입력해주세요 : ";
    private final String ball = "볼";
    private final String strike = "스트라이크";
    private final String nothing = "낫싱";

    private final String success = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String reStart = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final String ok = "1";
    private final String no = "2";


    public String inputAnyNumber() {
        System.out.print(inputText);
        return Console.readLine();
    }

    public void guideGameResult(GameResultStatus gameResultStatus) {
        String resultComment = generateResultGameComment(gameResultStatus);
        System.out.println(resultComment);
        if (gameResultStatus.isSameNumber()) {
            System.out.println(success);
        }
    }

    private String generateResultGameComment(GameResultStatus gameResultStatus) {
        String ballComment = gameResultStatus.generateBallComment(ball);
        String strikeComment = gameResultStatus.generateStrikeComment(strike);

        StringBuilder resultGameComment = new StringBuilder();
        if (ballComment == null && strikeComment == null) {
            return resultGameComment.append(nothing).toString();
        }
        assembleStateComment(resultGameComment, ballComment, strikeComment);

        return resultGameComment.toString();
    }

    private StringBuilder assembleStateComment(StringBuilder resultGameComment,
                                               String ballComment,
                                               String strikeComment) {
        if (ballComment != null) {
            resultGameComment.append(ballComment);
        }
        if (strikeComment != null) {
            resultGameComment.append(strikeComment);
        }
        return resultGameComment;
    }

    public boolean confirmRestartGame() {
        System.out.println(reStart);
        String reStarted = Console.readLine();
        if (ok.equals(reStarted)) {
            return true;
        }
        if (no.equals(reStarted)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
