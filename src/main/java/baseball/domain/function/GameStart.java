package baseball.domain.function;

import baseball.game.Context;

public class GameStart implements Functions {

    @Override
    public Functions command(Context context) {
        context.init();
        return new WaitUserInput();
    }

    @Override
    public boolean isPlay() {
        return true;
    }

}
