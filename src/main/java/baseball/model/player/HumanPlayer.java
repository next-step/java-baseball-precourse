package baseball.model.player;

public class HumanPlayer extends Player {
    private int trialCount;

    public HumanPlayer() {
        this.trialCount = 0;
    }

    public int getTrialCount() {
        return trialCount;
    }

    public void addTrialCount() {
        this.trialCount++;
    }

    @Override
    public void setInputNumber(String inputNumber) {
        super.setInputNumber(inputNumber);
        addTrialCount();
    }
}
