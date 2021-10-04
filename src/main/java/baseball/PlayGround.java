package baseball;

public class PlayGround {
    private Trial computerTrial;
    private PlayResult recentPlayResult;

    public void setComputerTrial(Trial newComputerTrial) {
        this.computerTrial = newComputerTrial;
        this.recentPlayResult = null;
    }

    public boolean run(Trial userTrial) {
        this.recentPlayResult = this.computerTrial.play(userTrial);

        System.out.println(this.recentPlayResult.toString());

        return this.recentPlayResult.isGameEnd();
    }
}
