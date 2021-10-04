package baseball;

public class Game {
    private final Player defender;
    private final Player attacker;
    private final Ruler ruler;
    private final boolean runnable = true;

    public Game(Player defender, Player attacker, Ruler ruler) {
        this.defender = defender;
        this.attacker = attacker;
        this.ruler = ruler;
    }

    public boolean isRunnable() {
        return runnable;
    }

    public void run() {
        // todo : check status
        if (!runnable) throw new RuntimeException("");

        // todo : make right number
        Number rightNumber = defender.pick();

        // todo : repeat until get right answer
        Number expectedNumber = attacker.pick();
        Result result = ruler.compareNumber(rightNumber, expectedNumber);
        System.out.println(result);

        // todo : get next command & change status
    }
}
