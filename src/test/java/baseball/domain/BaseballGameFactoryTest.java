package baseball.domain;

import baseball.strategy.RandomNumberStrategy;
import baseball.strategy.RandomUniqueNumberStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameFactoryTest {

    RandomNumberStrategy strategy;
    BaseballGameRule gameRule;
    Computer computer;

    @BeforeEach
    void init() {
        strategy = RandomUniqueNumberStrategy.getInstance();
        gameRule = new BaseballGameRule();
        computer = Computer.builder().strategy(strategy).build();
    }

    @Test
    public void 게임_생성_테스트() throws Exception {
        // given
        BaseballGameFactory factory = BaseballGameFactory.builder()
                .computer(computer)
                .baseballGameRule(gameRule)
                .build();
        // when
        BaseballGame game = factory.createGame();
        // then
        assertThat(game).isInstanceOf(BaseballGame.class);
    }

}