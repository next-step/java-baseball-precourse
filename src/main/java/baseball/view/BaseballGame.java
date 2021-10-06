package baseball.view;

import baseball.comm.Constant;
import baseball.model.Judgment;
import baseball.model.Opponent;
import nextstep.utils.Console;

public class BaseballGame {

    public static int strike = 0;
    public static int ball = 0;

    private static final BaseballGame BASEBALL_GAME = new BaseballGame();

    private BaseballGame() {}

    public static BaseballGame getInstance() {
        return BASEBALL_GAME;
    }

    // 숫자 야구 게임 시작
    public void playBall(){
        // 판정을 하기 위한 객체
        Judgment judgment = Judgment.getInstance();

        // 상대방 난수 생성
        Opponent opponent = Opponent.getInstance();
        String oppnentNumbers = opponent.makeNumber();

        do{
            String playerNumbers = getPlayInputNumbers();
            resetScore();
            judgment.judgment(oppnentNumbers,playerNumbers);
            getPlayResult();
        } while (strike < Constant.GAME_END_STRIKE);
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void getPlayResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strike > 0) System.out.printf("%d 스트라이크 ", strike);

        if (ball > 0) System.out.printf("%d 볼", ball);

        System.out.println();

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

    // 입력 받은 사용자 수 확인하기
    private boolean validationData(String playerInputNumber) {
        // 사용자 입력 값이 숫자만 존재하는지 확인
        if(validationNum(playerInputNumber)) {
            System.out.println(Constant.NUMBER_MESSAGE);
            return true;
        }
        // 입력 된 값이 3자리 이상인지 확인
        if(validationLenth(playerInputNumber)) {
            System.out.println(Constant.LENGTH_MESSAGE);
            return true;
        }
        return false;
    }

    private boolean validationNum(String playerInputNumber) {
        return !Constant.IS_ONLY_NUMBER.matcher(playerInputNumber).matches();
    }

    private boolean validationLenth(String playerInputNumber) {
        return playerInputNumber.length() != Constant.NUM_SIZE;
    }

    public boolean contiuePlay(){
        if (strike == Constant.NUM_SIZE){
            System.out.println("3 스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임 끝");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        String contiueFlag = Console.readLine();
        return !contiueFlag.equals("2");
    }
}


