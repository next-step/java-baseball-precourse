package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseballGameTest {
    private static final int TEST_SIZE = 10000;

    @Test
    void generateGameAnswer_has_size_three() {
        for (int i = 0; i < TEST_SIZE; i++) {
            int[] result = BaseballGame.generateGameAnswer();
            assertThat(result).hasSize(3);
        }
    }

    @Test
    void generateGameAnswer_consist_of_distinct_number() {
        for (int i = 0; i < TEST_SIZE; i++) {
            int[] result = BaseballGame.generateGameAnswer();
            List<Integer> numberList = Arrays.stream(result).boxed().collect(Collectors.toList());
            assertThat(numberList).doesNotHaveDuplicates();
        }
    }

    @Test
    void generateGameAnswer_consist_of_1_to_9() {
        for (int i = 0; i < TEST_SIZE; i++) {
            int[] result = BaseballGame.generateGameAnswer();
            assertThat(result[0]).isGreaterThanOrEqualTo(1);
            assertThat(result[0]).isLessThanOrEqualTo(9);
            assertThat(result[1]).isGreaterThanOrEqualTo(1);
            assertThat(result[1]).isLessThanOrEqualTo(9);
            assertThat(result[2]).isGreaterThanOrEqualTo(1);
            assertThat(result[2]).isLessThanOrEqualTo(9);
        }
    }

    @Test
    void isValid_정상_user_input_인경우_true() {
        boolean result = BaseballGame.isValid("234");
        assertTrue(result);
    }

    @Test
    void isValid_4자리_user_input인경우_false() {
        boolean result = BaseballGame.isValid("1234");
        assertFalse(result);
    }

    @Test
    void isValid_문자가_포함된_user_input인경우_false() {
        boolean result = BaseballGame.isValid("1a4");
        assertFalse(result);
    }

    @Test
    void nonMatch_정답숫자중_하나도_포함하지_않는_경우_true() {
        //given
        int[] customAnswer = new int[]{1, 2, 3};
        int[] userInput = new int[]{4, 5, 6};
        BaseballGame game = new BaseballGame(customAnswer);
        game.grade(userInput);
        //when
        boolean result = game.nonMatch();
        //then
        assertTrue(result);
    }

    @Test
    void nonMatch_정답숫자중_일부_포함하는_경우_false() {
        //given
        int[] customAnswer = new int[]{1, 2, 3};
        int[] userInput = new int[]{4, 3, 6};
        BaseballGame game = new BaseballGame(customAnswer);
        game.grade(userInput);
        //when
        boolean result = game.nonMatch();
        //then
        assertFalse(result);
    }

    @Test
    void allMatch_3스트라이크인_경우_true() {
        //given
        int[] customAnswer = new int[]{4, 1, 5};
        int[] userInput = new int[]{4, 1, 5};
        BaseballGame game = new BaseballGame(customAnswer);
        game.grade(userInput);
        //when
        boolean result = game.allMatch();
        //then
        assertTrue(result);
    }

    @Test
    void allMatch_2스트라이크_1볼인_경우_false() {
        //given
        int[] customAnswer = new int[]{4, 1, 5};
        int[] userInput = new int[]{4, 1, 6};
        BaseballGame game = new BaseballGame(customAnswer);
        game.grade(userInput);
        //when
        boolean result = game.allMatch();
        //then
        assertFalse(result);
    }

    @Test
    void getStrikeCount_2개일치하는_경우() {
        //given
        int[] customAnswer = new int[]{4, 1, 5};
        int[] userInput = new int[]{4, 1, 6};
        BaseballGame game = new BaseballGame(customAnswer);
        game.grade(userInput);
        //when
        int result = game.getStrikeCount();
        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void getBallCount_1strike_2ball_인경우() {
        //given
        int[] customAnswer = new int[]{4, 1, 5};
        int[] userInput = new int[]{4, 5, 1};
        BaseballGame game = new BaseballGame(customAnswer);
        game.grade(userInput);
        //when
        int result = game.getBallCount();
        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 답이_169_인경우() {
        //given
        int[] customAnswer = new int[]{1, 6, 9};
        int[] userInput = new int[]{1, 7, 9};
        BaseballGame game = new BaseballGame(customAnswer);
        game.grade(userInput);
        //when
        int ballCount = game.getBallCount();
        int strikeCount = game.getStrikeCount();
        //then
        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(2);
    }
}
