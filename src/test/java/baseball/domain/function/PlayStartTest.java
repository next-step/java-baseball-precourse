package baseball.domain.function;

import baseball.domain.computer.Computer;
import baseball.game.Context;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayStartTest {

    private Context context;
    private Functions functions;


    @BeforeEach
    void setUp(){
        String input = "123";
        byte[] buf = input.getBytes(StandardCharsets.UTF_8);
        System.setIn(new ByteArrayInputStream(buf));
        context = new Context();
        functions = new GameStart();

    }





    @Test
    void 숫자가_똑같다면_finish상태로_전환(){

        final MockedStatic<Randoms> samRndNumMock = mockStatic(Randoms.class);
        samRndNumMock.when(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt())
        ).thenReturn(1, 1, 2, 3);

        functions = functions.command(context);//gameStart -> WaitInput
        functions = functions.command(context);//WaitInput -> finishGame

        Functions actual = functions.command(context);
        assertThat(actual.getClass()).isEqualTo(FinishGame.class);

        samRndNumMock.close();

    }


    @Test
    void 숫자가_다르다면_WaitInput상태로_전환(){

        final MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt())
        ).thenReturn(1, 1, 7, 4);

        functions = functions.command(context);//gameStart -> WaitInput
        functions = functions.command(context);//WaitInput -> WaitUserInput

        Functions actual = functions.command(context);
        assertThat(actual.getClass()).isEqualTo(WaitUserInput.class);

        mock.close();
    }

}