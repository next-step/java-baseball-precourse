package baseball.game;

import baseball.context.GameCycle;
import baseball.context.Numbers;
import baseball.context.RestartPolicy;

public class Game implements GameCycle {

    private final Computer computer;
    private final Player player;
    private final RestartPolicy restartPolicy;

    public Game(Computer computer, Player player, RestartPolicy restartPolicy) {
        this.computer = computer;
        this.player = player;
        this.restartPolicy = restartPolicy;
    }

    public boolean playable = true;

    @Override
    public void onPlay() {
        Numbers numbers = player.present();
        computer.match(numbers);
        computer.printResult();
    }

    @Override
    public void onEnd() {
        restartPolicy.restart(computer.lose(),
            this::onRefresh,
            this::onExit);
    }

    @Override
    public void onRefresh() {
        computer.generateNumber();
    }

    public void onExit() {
        this.playable = false;
    }
}
