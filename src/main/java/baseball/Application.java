package baseball;

public class Application {
    public static void main(String[] args) {
        final int numberOfAttemptNumber = 3;
        final GameManager gm = new GameManager(
                numberOfAttemptNumber,
                new DefaultRandomNumberGenerator(numberOfAttemptNumber),
                camp.nextstep.edu.missionutils.Console::readLine,
                new CommandLineView());

        gm.startGame();
    }
}
