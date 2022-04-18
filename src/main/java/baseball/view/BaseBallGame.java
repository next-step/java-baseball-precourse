package baseball.view;

import baseball.comm.Constant;
import baseball.service.OpponentPlayer;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private static int strike;
    private static int ball;
    private static final BaseBallGame BASEBALL_GAME = new BaseBallGame();
    private BaseBallGame(){

    }
    public static BaseBallGame getInstance(){
        return BASEBALL_GAME;
    }

    public void playBall(){
        OpponentPlayer opponentPlayer = OpponentPlayer.getInstance();
        String oppnentNumbers = opponentPlayer.makeNumber();
        do{
            resetScore();
            String playerNumbers = getPlayInputNumbers();
        } while (strike < Constant.GAME_END_STRIKE);
    }

    // 게임을 새로 시작히가 위한 초기화
    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    // 사용자 값 입력 받기
    private String getPlayInputNumbers(){
        String playerInputNumber;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            playerInputNumber = Console.readLine();
        } while ( validationData (playerInputNumber) );
        return playerInputNumber;
    }

    private boolean validationData(String playerInputNumber) {
        // 사용자 입력 값이 숫자만 존재하는지 확인
        if(validationNum(playerInputNumber)) {
            throw new IllegalArgumentException(Constant.NUMBER_MESSAGE);
        }
        // 입력 된 값이 3자리 이상인지 확인
        if(validationLenth(playerInputNumber)) {
            throw new IllegalArgumentException(Constant.LENGTH_MESSAGE);
        }
        return false;
    }

    private boolean validationNum(String playerInputNumber) {
        return !Constant.IS_ONLY_NUMBER.matcher(playerInputNumber).matches();
    }

    private boolean validationLenth(String playerInputNumber) {
        return playerInputNumber.length() != Constant.NUM_SIZE;
    }


}