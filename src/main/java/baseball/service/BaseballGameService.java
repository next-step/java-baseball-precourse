package baseball.service;

import baseball.domain.Pitches;
import baseball.domain.StrikeBalls;
import baseball.view.ConsolePrinter;
import baseball.view.MessageFormater;
import baseball.view.Messages;
import baseball.view.ConsoleScanner;

public class BaseballGameService {
    private StrikeBalls strikeBalls;
    private Pitches pitches;

    public void playGame() {

        strikeBalls = new StrikeBalls();
        int cntStrike = 0;
        int cntBall = 0;
        do {
            ConsolePrinter.printConsoleMsg(Messages.ASK_USER_INPUT.getMsg());

            pitches = getPitches();

            cntStrike = getStrikeCount(strikeBalls, pitches);

            cntBall = getBallCount(strikeBalls, pitches);

            ConsolePrinter.printConsoleMsg(MessageFormater.getGameRsltMsg(cntBall, cntStrike));
        } while (cntStrike != Pitches.NUM_BALL_LEN);
        ConsolePrinter.printConsoleMsg(Messages.NOTIFY_END_OF_GAME.getMsg());
    }

    private Pitches getPitches() {
        String userInput = ConsoleScanner.getUserInput();
        pitches = new Pitches(userInput);

        return pitches;
    }

    public int getStrikeCount(StrikeBalls strikeBalls, Pitches pitches) {
        int count = 0;
        for (int i = 0; i < Pitches.NUM_BALL_LEN; i++) {
            count += isStrikeAt(strikeBalls, pitches, i) ? 1 : 0;
        }
        return count;
    }

    private boolean isStrikeAt(StrikeBalls strikeBalls, Pitches pitches, int index) {
        if (strikeBalls.getStrikeBall(index) == pitches.getPitch(index)) {
            return true;
        }
        return false;
    }

    public int getBallCount(StrikeBalls strikeBalls, Pitches pitches) {
        int count = 0;
        for (int i = 0; i < Pitches.NUM_BALL_LEN; i++) {
            count += isBallAt(strikeBalls, pitches, i) ? 1 : 0;
        }
        return count;
    }

    private boolean isBallAt(StrikeBalls strikeBalls, Pitches pitches, int index) {
        int pitch = pitches.getPitch(index);
        if (strikeBalls.contains(pitch) && pitch != strikeBalls.getStrikeBall(index)) {
            return true;
        }
        return false;
    }

}
