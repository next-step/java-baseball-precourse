package baseball.domain.function;

import baseball.game.Context;
import baseball.game.GameResult;
import baseball.io.OutputFunction;

public class PlayStart implements Functions {

    @Override
    public Functions command(Context context) {

        GameResult gameResult = context.compare();
        OutputFunction.println(gameResult.toString());
        if(gameResult.resultOfCompareAnswer() == true){
            return new FinishGame();
        }

        return new WaitUserInput();
    }

    @Override
    public boolean isPlay() {
        return true;
    }
}
