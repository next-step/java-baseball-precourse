package baseball;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Map<Enum<GameState>, Runnable> map;
    GameEvent event;
    Referee referee;
    PrintGame out;
    UserInput in;

    public Controller() {
        event = new GameEvent();
        event.setState(GameState.INIT);
        referee = new Referee();
        out = new PrintGame();
        in = new UserInput();
        mappingController();
    }

    private void mappingController() {
        map = new HashMap<>();
        map.put(GameState.INIT, this::initGame);
        map.put(GameState.REFEREECHECK, this::refereeCheck);
        map.put(GameState.END, this::endGame);
        map.put(GameState.CHECKRESTART, this::checkRestartGame);
        map.put(GameState.EXIT, this::exitGame);
    }

    //GameState.INIT
    public void initGame() {
        referee.setRandomNumber(ThreeDigit.get());
        event.setState(GameState.REFEREECHECK);
    }

    //GameState.REFEREECHECK
    public void refereeCheck() {
        out.printUserInput();
        String input = null;
        try {
            event.setState(GameState.REFEREECHECK);
            input = in.ball();
            BallState ballState = referee.checkBallState(input);
            out.printBallState(ballState);
            chaeckGameOut(ballState);
        } catch (Exception e) {
            out.printError(e.getMessage());
        }
    }

    //GameState.END
    public void endGame() {
        out.printEndGame();
        event.setState(GameState.CHECKRESTART);
    }

    //GameState.RESTART
    public void checkRestartGame() {
        out.printCheckExitGame();
        String input = null;
        try {
            event.setState(GameState.CHECKRESTART);
            input = in.restartGame();
            event.setState(GameState.INIT);
            checkExitGame(input);
        } catch (Exception e) {
            out.printError(e.getMessage());
        }
    }

    private void chaeckGameOut(BallState ballState) {
        if (ballState.isOut()) {
            event.setState(GameState.END);
        }
    }

    private void checkExitGame(String input) {
        if (input.equals("2")) {
            event.setState(GameState.EXIT);
        }
    }

    //GameState.EXIT
    private void exitGame() {
        System.exit(0);
    }

    public void run() {
        map.get(event.getState()).run();
    }
}
