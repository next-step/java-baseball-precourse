package baseball;

import baseball.domain.GameMessage;
import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

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

    @ParameterizedTest
    @ValueSource(
      strings = {
        "aaa", "11a", "ab0",      // with letters
        "  ", "      ",              // empty
        "112", "121", "211", "111",      // with repeats
        "012", "102", "120",             // with zero
        "1", "12", "1234", "123457896" // shorter/longer then three
      }
    )
    void 단일게임_진행_중_올바르지_않은_입력(String input) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
              .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
              .thenReturn(1,2,3);
            running(input);
            verify(GameMessage.ERR_PUT_ONLY_THREE_NUMBERS.getMessage());
        }
    }

    @Test
    void 단일게임_종료_후_재시작_여부_확인_시_올바르지_않은_입력() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
              .thenReturn(1,2,3);
            running("123", "a", "aa", "3", "11", "0", "", "  ");
            verify(GameMessage.ERR_PUT_ONLY_1_OR_2.getMessage());
        }
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
