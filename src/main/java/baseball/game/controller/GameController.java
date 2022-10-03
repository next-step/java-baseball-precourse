package baseball.game.controller;

import baseball.ball.domain.Ball;
import baseball.ball.domain.BallLocation;
import baseball.ball.domain.BallNumber;
import baseball.common.CharUtils;
import baseball.game.domain.Game;
import baseball.game.ui.console.input.InputConsole;
import baseball.game.ui.console.output.OutputConsole;
import baseball.pitching.domain.Pitching;
import baseball.referee.domain.Referee;
import baseball.zone.domain.Zone;

import java.math.BigDecimal;

public class GameController {

    public static void run() {
        Game game = gameInit();
        Zone zone = zoneInit();
        do {
            Referee referee = new Referee(zone, createPitching());
            printJudgement(referee);
            referee.judgeGame(game);
            restart(game, zone);
        } while (game.isPlaying());
    }

    private static void printJudgement(Referee referee) {
        OutputConsole outputConsole = new OutputConsole(referee.judgeBallCount(), referee.judgeStrikeCount());
        outputConsole.print();
    }

    private static Zone zoneInit() {
        Zone zone = new Zone();
        zone.generate();
        return zone;
    }

    private static Game gameInit() {
        Game game = new Game();
        game.start();
        return game;
    }

    private static Pitching createPitching() {
        char[] array = InputConsole.read();
        Pitching pitching = new Pitching();
        for (char number : array) {
            pitching.add(new Ball(new BallNumber(CharUtils.convertBigDecimal(number)), new BallLocation(BigDecimal.valueOf(pitching.pitchingBalls().size() + 1))));
        }
        return pitching;
    }

    private static void restart(Game game, Zone zone) {
        if (game.isEnd() && InputConsole.askRestart()) {
            game.start();
            zone.generate();
        }
    }

}
