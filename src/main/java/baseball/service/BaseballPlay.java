package baseball.service;

import baseball.domain.RandomNumberProvider;
import baseball.domain.StrikeWinne;
import baseball.domain.Swing;
import baseball.domain.WinneStrategy;
import baseball.utils.Printer;
import baseball.utils.Scanner;

import java.util.List;

public class BaseballPlay {

    private final WinneStrategy winneStrategy;
    private final Swing swing;
    private final List<Integer> randomNumbers;
    private boolean play = true;

    public BaseballPlay() {
        this.winneStrategy = new StrikeWinne();
        this.swing = new Swing();
        this.randomNumbers = RandomNumberProvider.randomNumberCreate();
    }

    public boolean play() {
        while(play) {
            Printer.swingNumberInput();
            swing(this.randomNumbers);
            winne();
        }
        return reGame();
    }

    private void swing(final List<Integer> randomNumbers) {
        List<Integer> swingNumbers = Scanner.swingNumber();
        swing.swinged(randomNumbers, swingNumbers);
        Printer.result(swing);
    }

    private void winne() {
        if (winneStrategy.winne(swing)) {
            play = false;
            Printer.gameOver();
        }
    }

    private boolean reGame() {
        if (Scanner.gameCommand() == 1) {
            return true;
        }
        return false;
    }
}
