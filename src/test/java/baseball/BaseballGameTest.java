package baseball;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballGameTest {

    @Test
    public void baseballGameInitTest() {
        BaseballGame game = new BaseballGame();
        assertThat(game.getNum()).isEqualTo(new int[3]);
    }

    @Test
    public void baseballGameRandomTest() {
        BaseballGame game = new BaseballGame();
        game.setRandomNumber();
        assertThat(game.getNum())
                .isNotEqualTo(new int[3])
                .doesNotContain(0);
    }

    @Test
    public void baseballGameSetNumBlankTest() {
        BaseballGame game = new BaseballGame();
        assertThatThrownBy(() -> game.setNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 입력되었습니다 -> ");
    }

    @Test
    public void baseballGameSetNumStringTest() {
        BaseballGame game = new BaseballGame();
        assertThatThrownBy(() -> game.setNumber("aaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 입력되었습니다 -> aaa");
    }

    @Test
    public void baseballGameSetNum123Test() {
        BaseballGame game = new BaseballGame();
        assertThat(game.setNumber("123"))
                .isEqualTo(true);
        assertThat(game.getNum())
                .isEqualTo(new int[]{1, 2, 3});
    }

    @Test
    public void baseballGameSetNum123Input123Test() {
        BaseballGame game = new BaseballGame();
        assertThat(game.setNumber("123"))
                .isEqualTo(true);
        assertThat(game.getNum())
                .isEqualTo(new int[]{1, 2, 3});
        assertThat(game.inputCompareNumber("123"))
                .isEqualTo(new int[]{3, 0});
    }

    @Test
    public void baseballGameSetNum123Input321Test() {
        BaseballGame game = new BaseballGame();
        assertThat(game.setNumber("123"))
                .isEqualTo(true);
        assertThat(game.getNum())
                .isEqualTo(new int[]{1, 2, 3});
        assertThat(game.inputCompareNumber("321"))
                .isEqualTo(new int[]{1, 2});
    }

    @Test
    public void baseballGameSetNum123Input456Test() {
        BaseballGame game = new BaseballGame();
        assertThat(game.setNumber("123"))
                .isEqualTo(true);
        assertThat(game.getNum())
                .isEqualTo(new int[]{1, 2, 3});
        assertThat(game.inputCompareNumber("456"))
                .isEqualTo(new int[]{0, 0});
    }

    @Test
    public void baseballGameSetNum123Input231Test() {
        BaseballGame game = new BaseballGame();
        assertThat(game.setNumber("123"))
                .isEqualTo(true);
        assertThat(game.getNum())
                .isEqualTo(new int[]{1, 2, 3});
        assertThat(game.inputCompareNumber("231"))
                .isEqualTo(new int[]{0, 3});
    }

    @Test
    public void baseballGameSetNum246Input231Test() {
        BaseballGame game = new BaseballGame();
        assertThat(game.setNumber("246"))
                .isEqualTo(true);
        assertThat(game.getNum())
                .isEqualTo(new int[]{2, 4, 6});
        assertThat(game.inputCompareNumber("231"))
                .isEqualTo(new int[]{1, 0});
    }

    @Test
    public void baseballGameSetNuma12Test() {
        String inputNum = "a12";
        BaseballGame game = new BaseballGame();
        assertThatThrownBy(() -> game.setNumber(inputNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 입력되었습니다. -> " + inputNum);
    }

    @Test
    public void baseballGameSetNum1234Test() {
        String inputNum = "1234";
        BaseballGame game = new BaseballGame();
        assertThatThrownBy(() -> game.setNumber(inputNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 문자의 길이가 잘못되었습니다. -> " + inputNum);
    }
    @Test
    public void baseballGameSetNum012Test() {
        String inputNum = "012";
        BaseballGame game = new BaseballGame();
        assertThatThrownBy(() -> game.setNumber(inputNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0은 입력할 수 없습니다. -> " + inputNum);
    }

}
