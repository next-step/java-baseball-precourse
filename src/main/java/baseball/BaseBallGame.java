package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGame {

    private Player computer;
    private final Player user;
    private static String gameStatus = "1";

    public BaseBallGame() {
        user = new Player();
        computer = new Player();
    }

    public void run() {
        do {
            start();
        } while (isRunning());
    }

    private void start() {
        computer = new Player(true);
        do {
            String baseballs = input();

            if (menuValidation(baseballs)) {
                calc(baseballs);
            }
        } while (Config.START_GAME.equals(gameStatus));
    }

    public boolean isRunning() {
        return !Config.STOP_GAME.equals(gameStatus);
    }

    private String input() {
        System.out.printf("%s: ", Message.INPUT.message);
        return readLine();
    }

    private void menu() {
        System.out.println(Message.GAME_INFO.message);
        menuValidation(readLine());
    }

    private boolean menuValidation(String baseballs) {
        if (isStartMenu(baseballs)) {
            return false;
        }

        return !isStopMenu(baseballs);
    }

    private boolean isStartMenu(String menu) {
        if (Config.START_GAME.equals(menu)) {
            start();
            return true;
        }

        return false;
    }

    private boolean isStopMenu(String menu) {
        if (Config.STOP_GAME.equals(menu)) {
            stop();
            return true;
        }

        return false;
    }

    public void calc(String baseballs) {
        user.setBaseBalls(baseballs);

        Score score = new Score(computer.getBaseBalls(), user.getBaseBalls());

        if (is3Strike(score.getResult())) {
            menu();
        }
    }

    public boolean is3Strike(String result) {
        System.out.println(result);

        if (String.format("%d%s", Config.MAX_NUMBER, GameType.스트라이크.name()).equals(result)) {
            System.out.printf("%s %s%n", Message.GAME_WIN.message, Message.GAME_STOP.message);
            return true;
        }

        return false;
    }

    public void stop() {
        gameStatus = Config.STOP_GAME;
        System.out.print(Message.GAME_STOP.message);
    }

}