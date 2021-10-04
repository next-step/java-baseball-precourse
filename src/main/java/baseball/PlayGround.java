package baseball;

public class PlayGround {
    private Trial trial;
    private PlayResult recentPlayResult;

    public void setComputerTrial(Trial trial) {
        this.trial = trial;
        this.recentPlayResult = null;
    }

    public boolean run(Trial counterTrial) {
        this.recentPlayResult = this.trial.play(counterTrial);

        return this.recentPlayResult.isGameEnd();
    }

    public void printPlayResult() {
        if (this.recentPlayResult == null) return;

        System.out.println(this.recentPlayResult.toString());
    }
}
