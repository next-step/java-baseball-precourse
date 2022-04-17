package baseball.domain;


import lombok.Builder;

public class BaseballGameFactory {

    private final Computer computer;
    private final BaseballGameRule baseballGameRule;

    @Builder
    public BaseballGameFactory(Computer computer, BaseballGameRule baseballGameRule) {
        this.computer = computer;
        this.baseballGameRule = baseballGameRule;
    }

    public BaseballGame createGame() {
        return BaseballGame.builder()
                .computer(computer)
                .baseballGameRule(baseballGameRule)
                .build();
    }
}
