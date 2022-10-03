package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelTest {

    private Model model;

    @BeforeEach
    void init() {
        model = new Model("713");
    }

    @DisplayName("낫싱 확인하기")
    @Test
    void test1() {
        model.setInput("456");

        assertThat(model.getHint()).isEqualTo("낫싱");
    }

    @DisplayName("1볼 1스트라이크 확인하기")
    @Test
    void test2() {
        model.setInput("123");

        assertThat(model.getHint()).isEqualTo("1볼 1스트라이크");
    }

    @DisplayName("1볼 확인하기")
    @Test
    void test3() {
        model.setInput("145");

        assertThat(model.getHint()).isEqualTo("1볼");
    }

    @DisplayName("2볼 확인하기")
    @Test
    void test4() {
        model.setInput("671");

        assertThat(model.getHint()).isEqualTo("2볼");
    }

    @DisplayName("3스트라이크 확인하기")
    @Test
    void test5() {
        model.setInput("713");

        assertThat(model.getHint()).isEqualTo("3스트라이크");
    }

}
