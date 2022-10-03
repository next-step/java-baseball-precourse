package baseball.domain;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PitchesTest extends NsTest {
    @Test
    void 사용자_입력값_길이_초과_시_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Pitches("1234");
        });

    }

    @Test
    void 사용자_입력값_길이_미만_시_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Pitches("1");
        });

    }

    @Test
    void 사용자_입력값_유효_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Pitches("abc");
        });
    }

    @Test
    void 사용자_입력값_중복_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Pitches("373");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"935", "123"})
    void Pitches_생성자_호출_시_값_생성_테스트(String input) {
        Pitches pitches = new Pitches(input);
        assertThat(pitches).isNotNull();

        String testVal = new String();
        for (int i = 0; i < Baseball.NUM_BALL_LEN; i++) {
            testVal += pitches.getPitch(i);
        }
        assertThat(input).isEqualTo(testVal);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
