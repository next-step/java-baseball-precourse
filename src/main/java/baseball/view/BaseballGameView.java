package baseball.view;

import baseball.model.JudgeModel;

public interface BaseballGameView {

    String inputPlayersTry();
    String inputOneMoreGame(String newGameCode, String quitGameCode);
    void responseJudge(JudgeModel judgeModel);
    void sayWelcome();
    void sayByeBye();
}
