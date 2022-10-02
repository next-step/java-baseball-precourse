package baseball.domain.function;

import baseball.Application;
import baseball.game.BaseBallGame;
import baseball.game.Context;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class WaitUserInputTest {

    @BeforeEach
    void setUp(){
        String input = "123";
        byte[] buf = input.getBytes(StandardCharsets.UTF_8);
        System.setIn(new ByteArrayInputStream(buf));
    }



    @Test
    void 입력대기에서_플레이스타트로가는가(){
        Context context = new Context();

        Functions functions = new WaitUserInput().command(context);

        assertThat(functions.getClass()).isEqualTo(PlayStart.class);
    }


}