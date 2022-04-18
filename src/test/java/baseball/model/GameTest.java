package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class GameTest {
    private static MockedStatic<Randoms> randoms;
    private static MockedStatic.Verification verification = () -> Randoms.pickNumberInRange(anyInt(), anyInt());
    @BeforeAll
    static void before() {
        randoms = mockStatic(Randoms.class);
    }

    @Test
    void 예상_결과값_테스트_1볼_1스 () {
        // computer : 1, 3, 2 return
        randoms.when(verification).thenReturn(1, 3, 2);
        Player computer = new Computer(3);
        // user 3, 4, 2 input
        Player user = new User("342", 3);

        Game game = new Game(user, computer);

        assertThat(game.getStrike()).isEqualTo(1);
        assertThat(game.getBall()).isEqualTo(1);
        assertThat(game.getNothing()).isEqualTo(0);
    }
    @Test
    void 예상_결과값_테스트_낫싱 () {
        // computer : 1, 3, 2 return
        randoms.when(verification).thenReturn(1, 3, 2);
        Player computer = new Computer(3);
        // user 4, 5, 6 input
        Player user = new User("456", 3);

        Game game = new Game(user, computer);

        assertThat(game.getStrike()).isEqualTo(0);
        assertThat(game.getBall()).isEqualTo(0);
        assertThat(game.getNothing()).isEqualTo(1);
    }

    @AfterAll
    public static void after() {
        randoms.close();
    }
}