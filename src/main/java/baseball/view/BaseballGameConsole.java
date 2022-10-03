package baseball.view;

import baseball.code.JudgeStatus;
import baseball.model.JudgeModel;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameConsole implements BaseballGameView {

    private static final String QUESTION_TRY = "숫자를 입력해주세요 : ";
    private static final String RESPONSE_COLLECT = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String QUESTION_ONE_MORE_GAME = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.";
    private static final String RESPONSE_BYE_BYE = "게임 종료";

    @Override
    public String inputPlayersTry() {
        System.out.print(QUESTION_TRY);
        return Console.readLine();
    }

    @Override
    public String inputOneMoreGame(String newGameCode, String quitGameCode) {
        System.out.printf(QUESTION_ONE_MORE_GAME, newGameCode, quitGameCode);
        return Console.readLine();
    }

    @Override
    public void responseJudge(JudgeModel judgeModel) {
        System.out.println(makeMessage(judgeModel));
        if(judgeModel.getJudgeStatus() == JudgeStatus.STRIKE){
            System.out.println(RESPONSE_COLLECT);
            return;
        }
    }

    @Override
    public void sayWelcome() {
    }

    @Override
    public void sayByeBye() {
        System.out.println(RESPONSE_BYE_BYE);
    }

    public String makeMessage(JudgeModel judgeModel){
        StringBuilder sb = appendMessage(judgeModel);

        if(judgeModel.getStrikeCount() + judgeModel.getBallCount() == 0){
            sb.append(JudgeStatus.NOTHING.getValue());
        }
        return sb.toString().trim();
    }

    public StringBuilder appendMessage(JudgeModel judgeModel){
        StringBuilder sb = new StringBuilder();

        if(judgeModel.getBallCount() > 0){
            sb.append(judgeModel.getBallCount()).append(JudgeStatus.BALL.getValue()).append(" ");
        }
        if(judgeModel.getStrikeCount() > 0){
            sb.append(judgeModel.getStrikeCount()).append(JudgeStatus.STRIKE.getValue());
        }

        return sb;
    }
}
