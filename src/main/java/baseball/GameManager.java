package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameManager {
    private final int numberOfTargetNumber;
    private final RandomNumberGenerator randomNumberGenerator;
    private final Supplier<String> readLineFn;
    private final Map<Integer, Runnable> dashboardFunctionMap;
    private final View view;

    public GameManager(int numberOfTargetNumber, RandomNumberGenerator randomNumberGenerator,
                       Supplier<String> readLineFn, View view) {
        this.numberOfTargetNumber = numberOfTargetNumber;
        this.randomNumberGenerator = randomNumberGenerator;
        this.readLineFn = readLineFn;
        this.dashboardFunctionMap = new HashMap<>();
        dashboardFunctionMap.put(1, this::startGame);
        dashboardFunctionMap.put(2, () -> {});

        this.view = view;
    }

    private void runDashboardCommand() {
        view.dashboard();
        final int command = Integer.parseInt(readLineFn.get());

        dashboardFunctionMap.getOrDefault(command, () -> { throw new IllegalArgumentException();})
                .run();
    }

    /**
     * 이기는 경우와 지는 경우.
     */
    public void startGame() {
        final BaseballGame baseballGame = new BaseballGame(
                numberOfTargetNumber,
                randomNumberGenerator,
                view,
                readLineFn);
        baseballGame.play();
        runDashboardCommand();
    }
}
