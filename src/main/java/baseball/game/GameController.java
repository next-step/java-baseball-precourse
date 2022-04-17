package baseball.game;

import baseball.answer.Answer;
import baseball.answer.AnswerConfig;
import baseball.answer.NumberStrategy;

public class GameController {
    GameService gameService;
    NumberStrategy numberStrategy;
    
    public GameController(GameService gameService, NumberStrategy numberStrategy){
        this.gameService = gameService;
        this.numberStrategy = numberStrategy;
    }

    public void gameStart(){
        GameStatus gameStatus = GameStatus.PLAY;
        while (gameStatus == GameStatus.PLAY){
            gameStatus = round();
        }
    }

    public GameStatus round(){
        Answer answer = new Answer(numberStrategy);
        GameRoundResult gameRoundResult = new GameRoundResult();
        while(gameRoundResult.getStrike() != AnswerConfig.ANSWER_LENGTH){
            String inputStr = GameView.inputView();
            int[] input = stringToIntArray(inputStr);
            gameRoundResult = gameService.compareAnswer(answer, new Answer(input));
            GameView.outputView(gameRoundResult);
        }
        String gameStatusNo = GameView.roundView();
        if (gameStatusNo.equals("1")){
            return GameStatus.PLAY;
        }
        return GameStatus.EXIT;
    }

    private int[] stringToIntArray(String str){
        int[] intArray = new int[str.length()];
        for (int idx = 0; idx < str.length(); idx++){
            intArray[idx] = chrToInt(str.charAt(idx));
        }
        return intArray;
    }

    private int chrToInt(char c){
        int result = Character.getNumericValue(c);
        if (result < 0 || result > 9){
            throw new IllegalArgumentException(String.format("입력 값이 유효한 숫자가 아닙니다. %c", c));
        }
        return result;
    }
}
