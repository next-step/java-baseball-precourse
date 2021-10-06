package baseball.controller;

import baseball.model.InningRepository;
/**
 * @author Lee SeungHwan <lshn1007@hanyang.ac.kr>
 * @version 1.2
 * @since 21-10-03
 */
public class AnswerCheck {
    private InningRepository inningRepository;

    public AnswerCheck(String answer){
        this.inningRepository = new InningRepository();
        this.inningRepository.setAnswer(answer);
    }

    public void checkPipeLine() {
        for(int i = 0; i < this.inningRepository.getAnswer().length(); i++)
            checkIndexAt(i);
    }
    /**
     * (1, 2, 3)번째 숫자를 각각 비교하여 스트라이크, 볼을 판단하는 메소드
     */
    public void checkIndexAt(int idx){
        if(!checkStrikeAt(idx))
            checkBallAt((idx));
    }

    /**
     * 특정 인덱스(이하 idx) 의 값을 비교하여 동일하면 strike count를 1개 늘린다
     */
    public boolean checkStrikeAt(int idx){
        if (this.inningRepository.getAnswer().charAt(idx) == this.inningRepository.getUserInput().charAt(idx)) { // condition of strike
            int now = this.inningRepository.getStrikeCnt();
            this.inningRepository.setStirikeCnt(now + 1);
            return true;
        }
        return false;
    }
    /**
     * 유저입력 숫자의 특정 인덱스(이하 idx) 의 값이 정답지에 퐇함되어 있으면 ball count를 1개 늘린다.
     */
    public void checkBallAt(int idx){
        if (this.inningRepository.getAnswer().contains(Character.toString(this.inningRepository.getUserInput().charAt(idx)))) { // condition of ball
            int now = this.inningRepository.getBallCnt();
            this.inningRepository.setBallCnt(now + 1);
        }
    }

    public void resetCount(){
        this.inningRepository.setStirikeCnt(0);
        this.inningRepository.setBallCnt(0);
    }

    public void setUserInput(String userInput){
        this.inningRepository.setUserInput(userInput);
    }

    public int getStrike(){
        return this.inningRepository.getStrikeCnt();
    }

    public int getBall(){
        return this.inningRepository.getBallCnt();
    }
}
