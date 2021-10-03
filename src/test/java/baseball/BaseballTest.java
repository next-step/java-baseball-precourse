package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static baseball.Baseball.END_INCLUSIVE;
import static baseball.Baseball.START_INCLUSIVE;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    private final Method generateCustomAnswerMethod;
    private final Method generateAnswerMethod;
    private final Method generateNewNumberMethod;
    private final Method getBallCountMethod;
    private final Method checkBallCountMethod;

    public BaseballTest() throws NoSuchMethodException {
        this.generateCustomAnswerMethod = Baseball.class.getDeclaredMethod("generateAnswer", Integer.class);
        generateCustomAnswerMethod.setAccessible(true);

        this.generateNewNumberMethod = Baseball.class.getDeclaredMethod("generateNewNumber", Map.class);
        generateNewNumberMethod.setAccessible(true);

        this.generateAnswerMethod = Baseball.class.getDeclaredMethod("generateAnswer");
        generateAnswerMethod.setAccessible(true);

        this.getBallCountMethod = Baseball.class.getDeclaredMethod("getBallCount", Integer.class);
        getBallCountMethod.setAccessible(true);

        this.checkBallCountMethod = Baseball.class.getDeclaredMethod("checkBallCount", BallCount.class, Integer.class, Integer.class);
        checkBallCountMethod.setAccessible(true);
    }


    @Test
    @DisplayName("generateNuwNumber | 랜덤으로 생성된 숫자의 범위 확인")
    public void generateNuwNumberTest1() throws InvocationTargetException, IllegalAccessException {
        // given
        Baseball baseball = new Baseball();
        Map<Integer, Integer> map = new HashMap<>();

        // when
        int newNumber = (int) generateNewNumberMethod.invoke(baseball, map);

        // then
        assertThat(newNumber).isGreaterThanOrEqualTo(START_INCLUSIVE);
        assertThat(newNumber).isLessThanOrEqualTo(END_INCLUSIVE);
    }

    @Test
    @DisplayName("generateNuwNumber | 랜덤으로 생성된 숫자 값 확인")
    public void generateNuwNumberTest2() throws InvocationTargetException, IllegalAccessException {
        // given
        Baseball baseball = new Baseball();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.put(8, 8);

        // when
        int newNumber = (int) generateNewNumberMethod.invoke(baseball, map);

        // then
        assertThat(newNumber).isEqualTo(9);
    }


    @Test
    @DisplayName("generateAnswer | 랜덤으로 생성된 숫자의 값 범위 확인")
    public void generateAnswerTest1() throws InvocationTargetException, IllegalAccessException {
        // given
        Baseball baseball = new Baseball();

        // when
        generateAnswerMethod.invoke(baseball);
        int answer = baseball.getAnswer();

        // then
        assertThat(answer).isGreaterThanOrEqualTo(100);
        assertThat(answer).isLessThanOrEqualTo(999);
    }

    @Test
    @DisplayName("generateAnswer | 랜덤으로 생성된 숫자의 각 자리수 확인")
    public void generateAnswerTest2() throws InvocationTargetException, IllegalAccessException {
        // given
        Baseball baseball = new Baseball();

        // when
        generateAnswerMethod.invoke(baseball);
        int answer = baseball.getAnswer();

        // then
        int n = answer;
        Set<Integer> set = new HashSet<>();
        while (n != 0) {
            int number = n % 10;
            set.add(number);
            n /= 10;
        }
        assertThat(set).hasSize(Baseball.N);
    }

    @Test
    @DisplayName("generateAnswer | 임의로 생성한 숫자 각 자리수 확인")
    public void generateAnswerTest3() throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        // given
        Baseball baseball = new Baseball();

        // when
        generateCustomAnswerMethod.invoke(baseball, 123);
        int answer = baseball.getAnswer();
        Field answerPositionMapField = Baseball.class.getDeclaredField("answerPositionMap");
        answerPositionMapField.setAccessible(true);
        Map<Integer, Integer> answerPositionMap = (Map<Integer, Integer>) answerPositionMapField.get(baseball);

        // then
        int n = answer;
        Set<Integer> set = new HashSet<>();
        while (n != 0) {
            int number = n % 10;
            set.add(number);
            n /= 10;
        }
        assertThat(set).hasSize(Baseball.N);
        assertThat(answerPositionMap).containsEntry(1, 1);
        assertThat(answerPositionMap).containsEntry(2, 2);
        assertThat(answerPositionMap).containsEntry(3, 3);
    }

    @Test
    @DisplayName("checkBallCount | Strike가 증가하는 경우 확인")
    public void checkBallCountTest1() throws InvocationTargetException, IllegalAccessException {
        // given
        Baseball baseball = new Baseball();

        BallCount ballCount = new BallCount();

        // when
        checkBallCountMethod.invoke(baseball, ballCount, 1, 1);

        // then
        assertThat(ballCount.getStrike()).isEqualTo(1);
        assertThat(ballCount.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("checkBallCount | Ball 증가하는 경우 확인")
    public void checkBallCountTest2() throws InvocationTargetException, IllegalAccessException {
        // given
        Baseball baseball = new Baseball();
        BallCount ballCount = new BallCount();

        // when
        checkBallCountMethod.invoke(baseball, ballCount, 2, 1);

        // then
        assertThat(ballCount.getStrike()).isEqualTo(0);
        assertThat(ballCount.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("checkBallCount | 아무것도 증가하지 않는 경우 확인")
    public void checkBallCountTest3() throws InvocationTargetException, IllegalAccessException {
        // given
        Baseball baseball = new Baseball();
        BallCount ballCount = new BallCount(0, 0);

        // when
        checkBallCountMethod.invoke(baseball, ballCount, 2, null);

        // then
        assertThat(ballCount.getStrike()).isEqualTo(0);
        assertThat(ballCount.getBall()).isEqualTo(0);
    }



    @Test
    @DisplayName("getBallCount | 숫자와 위치를 모두 맞출 경우 확인")
    public void getBallCountTest1() throws InvocationTargetException, IllegalAccessException {
        // given
        Baseball baseball = new Baseball();
        generateCustomAnswerMethod.invoke(baseball, 123);

        // when
        BallCount ballCount = (BallCount) getBallCountMethod.invoke(baseball, 123);

        // then
        assertThat(ballCount).isEqualTo(new BallCount(3, 0));
    }

    @Test
    @DisplayName("getBallCount | 숫자를 하나도 못 맞출 경우 확인")
    public void getBallCountTest2() throws InvocationTargetException, IllegalAccessException {
        // given
        Baseball baseball = new Baseball();
        generateCustomAnswerMethod.invoke(baseball, 123);

        // when
        BallCount ballCount = (BallCount) getBallCountMethod.invoke(baseball, 456);

        // then
        assertThat(ballCount).isEqualTo(new BallCount(0, 0));
    }


    @Test
    @DisplayName("getBallCount | 숫자는 모두 맞췄지만 위치가 모두 다를 경우 확인")
    public void getBallCountTest3() throws InvocationTargetException, IllegalAccessException {
        // given
        Baseball baseball = new Baseball();
        generateCustomAnswerMethod.invoke(baseball, 123);

        // when
        BallCount ballCount = (BallCount) getBallCountMethod.invoke(baseball, 312);

        // then
        assertThat(ballCount).isEqualTo(new BallCount(0, 3));
    }

}