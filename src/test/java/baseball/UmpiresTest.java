package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UmpiresTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2", "3:0", "0:3", "0:0"}, delimiter = ':')
    @DisplayName("스트라이크, 볼, 낫싱 프린트")
    void shout(int ball, int strike) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // given
        Umpires umpires = new Umpires(new Rule());

        // when
        Method method = umpires.getClass().getDeclaredMethod("shout", int.class, int.class);
        method.setAccessible(true);

        // then
        method.invoke(umpires, ball, strike);

    }

    @Test
    @DisplayName("게임 심판 및 게임 종료 여부 확인")
    void judgementAndIsEndGame() {
        // given
        Umpires umpires = new Umpires(new Rule());
        List<Integer> source = new ArrayList<>(Arrays.asList(1,2,4));
        List<Integer> target = new ArrayList<>(Arrays.asList(1,2,4));

        // when
        boolean result = umpires.judgementAndIsEndGame(source, target);

        // then
        assertTrue(result);

    }


}