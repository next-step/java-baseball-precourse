package baseball.game;

import java.util.Set;

import baseball.answer.Answer;
import baseball.answer.AnswerConfig;
import baseball.common.Utils;

public class GameServiceImpl implements GameService {

    @Override
    public GameRoundResult compareAnswer(Answer answer, Answer inputAnswer) {
        int[] answerNumbers = answer.getNumbers();
        int[] inputAnswerNumbers = inputAnswer.getNumbers();

        GameRoundResult gameRoundResult = new GameRoundResult();
        Set<Integer> answerSet = Utils.setOf(answerNumbers);
        
        for (int idx = 0; idx < AnswerConfig.ANSWER_LENGTH; idx++){
            judgeStrike(gameRoundResult, answerNumbers[idx], inputAnswerNumbers[idx]);
            judgeBall(gameRoundResult, answerSet, inputAnswerNumbers[idx]);
        }
        // 스트라이크면 볼에서도 카운팅
        gameRoundResult.setBall(gameRoundResult.getBall() - gameRoundResult.getStrike());

        return gameRoundResult;
    }

    private void judgeStrike(GameRoundResult gameRoundResult, int number1, int number2){
        if (number1 == number2){
            gameRoundResult.addStrike();
        }
    }

    private void judgeBall(GameRoundResult gameRoundResult, Set<Integer> answerSet, int number){
        if (answerSet.contains(number)){
            gameRoundResult.addBall();
        }
    }
    
}
