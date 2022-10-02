package baseball.domain;

public class StrikeWinne implements WinneStrategy {

    private static final int WINNE_STRIKE_SIZE = 3;

    @Override
    public boolean winne(final Swing swing) {
        return swing.getStrike() == WINNE_STRIKE_SIZE;
    }
}
