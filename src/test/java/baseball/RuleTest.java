package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    @Test
    @DisplayName("서로 다른 3자리 수의 같은 숫자, 0 포함 여부 확인")
    void hasSameOrZeroNumber() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        List<Integer> numbersTrue = new ArrayList<>(Arrays.asList(1,2,2));
        List<Integer> numbersFalse = new ArrayList<>(Arrays.asList(1,2,3));

        Rule rule = new Rule();
        Method method = rule.getClass().getDeclaredMethod("hasSameOrZeroNumber", List.class);
        method.setAccessible(true);

        // expect
        assertTrue((boolean) method.invoke(rule, numbersTrue));
        assertFalse((boolean) method.invoke(rule, numbersFalse));
    }

    @Test
    @DisplayName("서로 다른 3자리 수의 유효성 검사")
    void validateNumbers(){
        // given
        List<Integer> numbersTrue = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> numbersFalse = new ArrayList<>(Arrays.asList(1,2,2));

        // when
        Rule rule = new Rule();
        boolean isTrue = rule.validateNumbers(numbersTrue);
        boolean isFalse = rule.validateNumbers(numbersFalse);

        // expect
        assertTrue(isTrue);
        assertFalse(isFalse);
    }

    @Test
    @DisplayName("컴퓨터, 사용자 3자리 수의 스트라이크 갯수 반환")
    void countStrike(){
        // given
        List<Integer> source = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> target = new ArrayList<>(Arrays.asList(1,2,4));

        // when
        Rule rule = new Rule();
        int strike = rule.countStrike(source, target);

        // then
        assertEquals(2, strike);
    }

    @Test
    @DisplayName("컴퓨터, 사용자 3자리 수의 볼 갯수 반환")
    void countBall(){
        // given
        List<Integer> source = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> target = new ArrayList<>(Arrays.asList(2,1,4));

        // when
        Rule rule = new Rule();
        int ball = rule.countBall(source, target);

        // then
        assertEquals(2, ball);
    }

}