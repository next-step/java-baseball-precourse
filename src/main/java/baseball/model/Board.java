package baseball.model;

public class Board {
    private int[] goal;
    private int[] score;

    public int[] getGoal() {
        return goal;
    }

    public void setGoal(int[] goal) {
        this.goal = goal;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public Board() {
        this.goal = new int[3];
        this.score = new int[2];
    }
}
