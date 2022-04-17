package baseball.controller;

import baseball.constants.BaseballGameMessage;
import baseball.domain.BaseballGame;
import baseball.domain.BaseballGameFactory;
import baseball.domain.BaseballGameResult;
import baseball.ui.UserInterface;
import lombok.Builder;

public class BaseballGameController {

    private final BaseballGameFactory baseballGameFactory;
    private final UserInterface userInterface;

    private static final String RESTART_FLAG = "1";
    private static final String END_GAME_FLAG = "2";

    @Builder
    public BaseballGameController(final BaseballGameFactory baseballGameFactory
            , final UserInterface userInterface) {
        this.baseballGameFactory = baseballGameFactory;
        this.userInterface = userInterface;
    }

    public void execute() {
        BaseballGame game = baseballGameFactory.createGame();
        start(game);
    }

    private void start(BaseballGame game) {
        game.start();
        process(game);
    }

    private void process(BaseballGame game) {
        String inputs;
        BaseballGameResult result;
        while(false == game.isEnd()) {
            userInterface.output(BaseballGameMessage.NUMBER_INPUT.getMessage());
            inputs = userInterface.input();
            result = game.pitch(inputs);
            userInterface.output(result.toString()+"\n");
        }
        end(game);
    }

    private void end(BaseballGame game) {
        userInterface.output(BaseballGameMessage.END_GAME.getMessage()+"\n");
        userInterface.output(BaseballGameMessage.RESTART_GAME.getMessage()+"\n");
        String restartFlag = null;
        while(false == (RESTART_FLAG.equals(restartFlag)
                            || END_GAME_FLAG.equals(restartFlag))) {
            restartFlag = userInterface.input();
        }
        if(RESTART_FLAG.equals(restartFlag)) start(game);
    }
}
