package baseball.view;

import baseball.service.OpponentPlayer;

public class BaseBallGame {
    private static int strike = 0;
    private static int ball = 0;
    private static final BaseBallGame BASEBALL_GAME = new BaseBallGame();
    private BaseBallGame(){

    }
    public static BaseBallGame getInstance(){
        return BASEBALL_GAME;
    }

    public void playBall(){
        OpponentPlayer opponentPlayer = OpponentPlayer.getInstance();
        String oppnentNumbers = opponentPlayer.makeNumber();
    }

}