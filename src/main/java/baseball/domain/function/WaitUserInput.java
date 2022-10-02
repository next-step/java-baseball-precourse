package baseball.domain.function;

import baseball.game.Context;

public class WaitUserInput implements Functions {

    private String userInput;



    @Override
    public Functions command(Context context) {
        context.inputData();

        return new PlayStart();
    }

    @Override
    public boolean isPlay() {
        return true;
    }

}
