package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {
    BaseballGame game;
    BaseballGameRule gameRule;
    BaseballGameFactory factory;

    @BeforeEach
    void init() {
        gameRule = new BaseballGameRule();
        factory = BaseballGameFactory.builder().baseballGameRule(gameRule).build();
        game = factory.createGame();
    }

    @Test
    public void three_볼_체크() throws Exception {
        // given
        List<Integer> randomNumbers = Arrays.asList(3, 2, 1);
        game.setRandomNumbers(randomNumbers);
        // when
        String resultString = game.pitch("132").toString();
        // then
        assertThat(resultString).isEqualTo("3볼");
    }
    
    @Test
    public void three_스트라이크_체크() throws Exception {
        // given
        List<Integer> randomNumbers = Arrays.asList(3, 2, 1);
        game.setRandomNumbers(randomNumbers);
        // when
        String resultString = game.pitch("321").toString();
        // then
        assertThat(resultString).isEqualTo("3스트라이크");
    }

    @Test
    public void 볼_스트라이크_체크() throws Exception {
        // given
        List<Integer> randomNumbers = Arrays.asList(3, 2, 1);
        game.setRandomNumbers(randomNumbers);
        // when
        String resultString = game.pitch("123").toString();
        // then
        assertThat(resultString).isEqualTo("2볼 1스트라이크");
    }

    @Test
    public void three_스트라이크_게임종료_체크() throws Exception {
        // given
        List<Integer> randomNumbers = Arrays.asList(3, 2, 1);
        game.setRandomNumbers(randomNumbers);
        // when
        game.pitch("321");
        // then
        assertThat(game.isEnd()).isTrue();
    }

}