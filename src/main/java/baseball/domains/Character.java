package baseball.domains;

public abstract class Character {
    private String aimPositions;

    public abstract void play();

    public String getAimPositions() {
        return aimPositions;
    }

    protected void decideAimPositions(String aimPositions) {
        this.aimPositions = aimPositions;
    }


}
