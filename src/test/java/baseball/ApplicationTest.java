package baseball;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.MockedStatic;
import org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ApplicationTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 낫싱() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("246");
            verify("낫싱");
        }
    }

    @Test
    void 게임종료_후_재시작() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(7, 1, 3)
                    .thenReturn(5, 8, 9);
            run("713", "1", "597", "589", "2");
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
        }
    }

    @Test
    void 숫자가아닌입력값() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("abc");
            verify("[ERROR]");
        }
    }

    @Test
    void appendIfUnique_ShouldAppendUniqueElement() {
        StringBuilder testBuilder = new StringBuilder("123");
        String test = "4";
        Application.appendIfUnique(testBuilder, test);
        Assertions.assertThat(testBuilder.length())
                        .isEqualTo(4);
    }

    @Test
    void appendIfUnique_ShouldNotAppendOverlappingElement() {
        StringBuilder testBuilder = new StringBuilder("123");
        String test = "3";
        Application.appendIfUnique(testBuilder, test);
        Assertions.assertThat(testBuilder.length())
                .isEqualTo(3);
    }

    @Test
    void validateInput_ShouldReturnTrue() {
        Assertions.assertThat(Application.validateInput("123"))
                .isTrue();
    }

    @Test
    void validateInput_ShouldReturnFalseForOverSizeInput() {
        Assertions.assertThat(Application.validateInput("1234"))
                .isFalse();
    }

    @Test
    void validateInput_ShouldReturnFalseForOutOfRangeInput() {
        Assertions.assertThat(Application.validateInput("012"))
                .isFalse();
    }

    @Test
    void validateInput_ShouldReturnFalseForNoneDigitInput() {
        Assertions.assertThat(Application.validateInput("abc"))
                .isFalse();
    }

    @Test
    void isBall_ShouldReturnCorrectResult(){
        Assertions.assertThat(Application.isBall("123", "345", 0))
                .isEqualTo(1);
        Assertions.assertThat(Application.isBall("123", "345", 1))
                .isEqualTo(0);
    }

    @Test
    void isStrike_ShouldReturnCorrectResult(){
        Assertions.assertThat(Application.isStrike("123", "123", 1))
                .isEqualTo(1);
        Assertions.assertThat(Application.isStrike("123", "456", 1))
                .isEqualTo(0);
    }

    @Test
    void count_ShouldCountBallAndStrikeCorrectly(){
        int[] expected = {3, 0};
        Assertions.assertThat(Application.count("123", "123"))
                .isEqualTo(expected);
        int[] expected2 = {1, 2};
        Assertions.assertThat(Application.count("123", "132"))
                .isEqualTo(expected2);
    }

    @Test
    void generateResult_ShouldReturnNothing(){
        int[] input = {0, 0};
        Assertions.assertThat(Application.generateResult(input))
                .isEqualTo("낫싱");
    }

    @Test
    void generateResult_ShouldReturnStrikeOnly(){
        int[] input = {3, 0};
        Assertions.assertThat(Application.generateResult(input))
                .isEqualTo("3스트라이크 ");
    }

    @Test
    void generateResult_ShouldReturnBallOnly(){
        int[] input = {0, 3};
        Assertions.assertThat(Application.generateResult(input))
                .isEqualTo("3볼");
    }

    @Test
    void generateResult_ShouldReturnBallAndStrike(){
        int[] input = {2, 1};
        Assertions.assertThat(Application.generateResult(input))
                .isEqualTo("2스트라이크 1볼");
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
