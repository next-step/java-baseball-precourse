package baseball.model;

public class PlayGround {
    private PlayerState computerPlayerState;
    private PlayResult recentPlayResult;

    public void setComputerTrial(PlayerState newComputerPlayerState) {
        this.computerPlayerState = newComputerPlayerState;
        this.recentPlayResult = null;
    }

    public boolean run(PlayerState userPlayerState) {
        this.recentPlayResult = this.computerPlayerState.play(userPlayerState);

        System.out.println(this.recentPlayResult.toString());

        return this.recentPlayResult.isGameEnd();
    }
}
