package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @Test
    void 객체생성_테스트(){
        String numbers = "123";
        Player player = new Player();

        player.inputNumbers(numbers);

        assertThat(player).isNotNull();
        assertThat(player.getNumbers()).isNotNull();
    }

    @Test
    void 사용자_입력숫자_생성(){
        String numbers = "425";
        Player player = new Player();

        player.inputNumbers(numbers);

        assertThat(player.getNumbers().size()).isEqualTo(3);
        assertThat(player.getNumbers()).contains(4,2,5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "우테캠", "12동", "변99"})
    void 입력_오류_테스트(String input){

        Player player = new Player();
        assertThatIllegalArgumentException().isThrownBy(
                () -> player.inputNumbers(input)
        );
    }

    @Test
    void 숫자_클리어_테스트(){

        Player player = new Player();

        player.inputNumbers("123");
        assertThat(player.getNumbers().size()).isEqualTo(3);

        player.clearNumbers();
        assertThat(player.getNumbers().size()).isEqualTo(0);
    }

}