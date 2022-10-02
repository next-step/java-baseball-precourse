package baseball.domain.function;

import baseball.game.Context;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FinishGameTest {
    @Test
    void 일을_을눌렀을때_gameStart로가는가(){

        String input = "1";
        byte[] buf = input.getBytes(StandardCharsets.UTF_8);
        System.setIn(new ByteArrayInputStream(buf));

        Context context = new Context();
        Functions functions = new FinishGame().command(context);
        assertThat(functions.getClass()).isEqualTo(GameStart.class);

    }

    @Test
    void 이를_을눌렀을때_exitGame로가는가(){

        String input = "2";
        byte[] buf = input.getBytes(StandardCharsets.UTF_8);
        System.setIn(new ByteArrayInputStream(buf));

        Context context = new Context();
        Functions functions = new FinishGame().command(context);
        assertThat(functions.getClass()).isEqualTo(ExitGame.class);

    }

}