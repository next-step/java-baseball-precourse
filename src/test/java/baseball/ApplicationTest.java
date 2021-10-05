package baseball;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;

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
    void 올바르지_않은_Input() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running("abc", "111", "012");
            verify("[ERROR]", "[ERROR]", "[ERROR]");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"952", "912", "921", "562", "568"})
    void 볼1(String input) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running(input);
            verify("1볼");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"953", "913", "951", "512", "518"})
    void 볼2(String input) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running(input);
            verify("2볼");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"351", "513"})
    void 볼3(String input) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running(input);
            verify("3볼");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"167", "736", "895"})
    void 스트라이크1(String input) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running(input);
            verify("1스트라이크");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"152", "154", "156", "157", "158", "159", "532", "534", "536", "537", "538", "539"})
    void 스트라이크1_볼1(String input) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running(input);
            verify("1스트라이크 1볼");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"153", "531", "315"})
    void 스트라이크1_볼2(String input) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running(input);
            verify("1스트라이크 2볼");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"136", "137", "635", "935", "195"})
    void 스트라이크2(String input) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running(input);
            verify("2스트라이크");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"135"})
    void 스트라이크3(String input) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running(input);
            verify("3스트라이크", "게임 끝");
        }
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
