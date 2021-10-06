package baseball.view;

import baseball.controller.AnswerCheck;
import baseball.controller.InputValidator;

import nextstep.utils.Console;

public class GameConsole {
    private AnswerCheck answerCheck;

    public GameConsole(String answer){
        answerCheck = new AnswerCheck(answer);
    }

    /**
     * Play view
     */
    public void playScreen(){
        boolean isAnswer = false;
        do {
            isAnswer = tryPitch();
            this.answerCheck.resetCount();
        } while(!isAnswer);
    }

    /**
     * 1번의 피치 메소드
     */
    private boolean tryPitch(){
        System.out.print(CONSOLE_REPLY.INSERT_REPLY);
        String inputNumber = Console.readLine();
        if(!InputValidator.checkPipeLine(inputNumber))
            return false;
        this.answerCheck.setUserInput(inputNumber);
        this.answerCheck.checkPipeLine();
        refereeSpeak(this.answerCheck.getStrike(), this.answerCheck.getBall());
        return isFinish();
    }

    /**
     * 스트라이크 볼 개수에 따른 결과 선언
     */
    private void refereeSpeak(int strikeCnt, int ballCnt){
        if(strikeCnt != 0 && ballCnt == 0){
            System.out.println(strikeCnt + "스트라이크");
        } else if(strikeCnt != 0 && ballCnt != 0){
            System.out.println(strikeCnt + "스트라이크 " + ballCnt + "볼");
        } else if(strikeCnt == 0 && ballCnt != 0){
            System.out.println(ballCnt + "볼");
        } else if(strikeCnt == 0 && ballCnt == 0){
            System.out.println("낫싱");
        }
    }

    /**
     * 3 스트라이크인지 확인
     */
    private boolean isFinish(){
        if(this.answerCheck.getStrike() == 3){
            System.out.println(CONSOLE_REPLY.SUCCESS_REPLY);
            return true;
        }
        return false;
    }


    /**
     * End view : 시스템 종료 의사를 물어봄
     */
    public boolean endScreen(){
        System.out.println(CONSOLE_REPLY.REGAME_REPLY);
        String res = Console.readLine();
        if(res.equals("1")){
            return true;
        }
        else if(res.equals("2")){
            return false;
        }
        throw new IllegalArgumentException("[ERROR] : 1 또는 2를 입력하세요");
    }

    static class CONSOLE_REPLY{
        private static final String INSERT_REPLY = "숫자를 입력해주세요 : ";
        private static final String SUCCESS_REPLY = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
        private static final String REGAME_REPLY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }
}
