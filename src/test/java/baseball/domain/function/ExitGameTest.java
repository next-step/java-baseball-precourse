package baseball.domain.function;

import baseball.game.Context;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExitGameTest {

    @Test
    void 종료_클래스로가는가(){

        Context context = new Context();
        Functions functions = new ExitGame().command(context);
        assertThat(functions.getClass()).isEqualTo(ExitGame.class);

    }






}