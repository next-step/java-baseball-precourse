package baseball.control;

import baseball.model.BaseballGameModel;
import baseball.model.JudgeModel;
import baseball.view.BaseballGameConsole;
import baseball.view.BaseballGameView;

public class BaseballGame implements Game {

    public static final String NEW_GAME_CODE = "1";
    public static final String QUIT_GAME_CODE = "2";
    private BaseballGameModel gameModel;
    private BaseballGameView gameView;

    @Override
    public void init() {
        this.gameModel = new BaseballGameModel();
        this.gameView = new BaseballGameConsole();
    }

    @Override
    public boolean wantPlayingGame() {
        return gameModel.getWantNewGame();
    }

    @Override
    public void play() {
        while (gameModel.getNotYetCollectAnswer()) {
            String playersTry = gameView.inputPlayersTry();
            JudgeModel answer = gameModel.judge(validateAndConvert(playersTry));
            gameView.responseJudge(answer);
        }
        String playersCommand = gameView.inputOneMoreGame(NEW_GAME_CODE, QUIT_GAME_CODE);
        gameModel.setWantNewGame(playersCommand, NEW_GAME_CODE);
    }

    @Override
    public void quit() {
        gameView.sayByeBye();
    }

    private Integer[] validateAndConvert(String playerInput){

        validatePlayerInput(playerInput);
        return convertPlayerInput(playerInput);
    }

    private void validatePlayerInput(String playerInput){
        if(playerInput == null || playerInput.trim().length() != 3){
            throw new IllegalArgumentException("입력값이 유효하지 않습니다! 게임을 종료합니다.");
        }
    }

    private Integer[] convertPlayerInput(String playerInput){
        Integer[] inputNumbers = new Integer[3];
        String[] splittedInputs = playerInput.split("");
        try{
            for(int i = 0; i < splittedInputs.length; i++){
                inputNumbers[i] = Integer.valueOf(splittedInputs[i]);
            }
        }catch(Exception e){
            throw new IllegalArgumentException("입력값이 유효하지 않습니다! 게임을 종료합니다.");
        }
        return inputNumbers;
    }
}
