package baseball.domain.function;

import baseball.game.Context;

public interface Functions {
    Functions command(final Context context) ;

    boolean isPlay();
}
