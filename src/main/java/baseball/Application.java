package baseball;

public class Application {
    public static void main(String[] args) {
        Player defender = null;
        Player attacker = null;
        Ruler ruler = null;
        Game game = new Game(defender, attacker, ruler);

        while (game.isRunnable()) {
            game.run();
        }
    }
}
