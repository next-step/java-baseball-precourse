package baseball.domain.function;

import baseball.game.Context;
import baseball.io.OutputFunction;

public class ExitGame implements Functions {
    @Override
    public Functions command(final Context context) {
        return new ExitGame();
    }

    @Override
    public boolean isPlay() {
        return false;
    }
}
