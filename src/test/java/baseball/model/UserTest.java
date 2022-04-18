package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @Test()
    void 입력한_숫자_길이_테스트() {
        // given, when
        Player user = new User("123", 3);
        // then
        assertThat(user.getNumbers().size()).isEqualTo(3);
    }

    @Test()
    void 입력한_숫자_정상_저장_확인() {
        // given, when
        Player user = new User("123", 3);
        // then
        assertThat(user.getNumbers().get(0)).isEqualTo(1);
        assertThat(user.getNumbers().get(1)).isEqualTo(2);
        assertThat(user.getNumbers().get(2)).isEqualTo(3);
    }
}