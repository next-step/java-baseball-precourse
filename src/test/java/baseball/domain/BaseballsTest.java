package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballsTest {

    @Test
    public void MyBaseball객체_생성() {
        Baseballs myBaseballs = Baseballs.createMyBaseballs("123");
        assertThat(myBaseballs).isInstanceOf(Baseballs.class);
    }

    @Test
    public void ComBaseball객체_생성() {
        Baseballs comBaseballs = Baseballs.createComBaseballs();
        assertThat(comBaseballs).isInstanceOf(Baseballs.class);
    }

    @Test
    public void 숫자_길이_체크() {
        assertThatThrownBy(() -> {
            Baseballs baseballs = Baseballs.createMyBaseballs("1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자_중복_체크() {
        assertThatThrownBy(() -> {
            Baseballs baseballs = Baseballs.createMyBaseballs("122");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}