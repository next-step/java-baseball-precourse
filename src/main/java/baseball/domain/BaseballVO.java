package baseball.domain;

import baseball.common.Constant;

import java.util.List;

public class BaseballVO {
    // 정답
    private List<Integer> strikeNumberList;
    // 사용자입력값
    private List<Integer> answerNumberList;

    public static String MESSAGE_INPUT_REQUEST = "숫자를 입력해주세요 : ";
    public static String MESSAGE_END_REQUEST = Constant.DEFAULT_ANSWER_LENGTH+"개의 숫자를 모두 맞히셨습니다! 게임 끝\r\n게임을 새로 시작하려면 "+Constant.GAME_CONTINUE+", 종료하려면 "+Constant.GAME_FINISH+"를 입력하세요.";
    public static String ERROR_MESSAGE_EXCEPTION = "[ERROR] 예상치 못한 문제가 발생하였습니다.\r\n관리자에게 문의하세요.";
    public static String ERROR_MESSAGE_LENGTH = "[ERROR] "+Constant.DEFAULT_ANSWER_LENGTH+"자리 숫자를 입력해 주세요.";
    public static String ERROR_MESSAGE_NUMBER = "[ERROR] "+Constant.MIN_RANDOM_RANGE+"에서 "+Constant.MAX_RANDOM_RANGE+" 사이의 숫자만 입력해 주세요.";
    public static String ERROR_MESSAGE_DUPLICATE = "[ERROR] 숫자가 중복되지 않도록 입력해 주세요.";

    public BaseballVO() {
        this.cntStrike = 0;
        this.cntBall = 0;
        this.isNothing = false;
        this.isError = false;
        this.isStrike = false;
        this.isRestart = false;
        this.message = "";
        this.userAnswer = "";
    }

    /**
     * 사용자 출력 메세지 생성메소드
     * @return
     */
    public String resultMessage() {
        if (this.isError) {
            return this.getMessage() == null ? ERROR_MESSAGE_LENGTH : this.getMessage();
        }

        if (this.isNothing()) {
            return "낫싱";
        }

        // 스트라이크와 볼 합계가 정답자릿수보다 크다면 RUNTIME EXCEPTION
        if (this.cntStrike + this.cntBall > Constant.DEFAULT_ANSWER_LENGTH) {
            this.setError(true, ERROR_MESSAGE_EXCEPTION);
            return this.getMessage();
        }

        StringBuffer stringBuffer = new StringBuffer();
        if (this.getCntStrike() > 0) {
            stringBuffer.append(this.getCntStrike());
            stringBuffer.append("스트라이크 ");
        }

        if (this.getCntBall() > 0) {
            stringBuffer.append(this.getCntBall());
            stringBuffer.append("볼 ");
        }

        return stringBuffer.toString();
    }

    private int cntStrike;
    private int cntBall;
    private boolean isNothing;
    private boolean isError;
    private boolean isStrike;
    private boolean isRestart;
    private boolean isEndGame;
    private String message;
    private String userAnswer;

    public List<Integer> getStrikeNumberList() {
        return strikeNumberList;
    }

    public void setStrikeNumberList(List<Integer> strikeNumberList) {
        this.strikeNumberList = strikeNumberList;
    }

    public List<Integer> getAnswerNumberList() {
        return answerNumberList;
    }

    public void setAnswerNumberList(List<Integer> answerNumberList) {
        this.answerNumberList = answerNumberList;
    }
    public int getCntStrike() {
        return cntStrike;
    }

    public void setCntStrike(int cntStrike) {
        this.cntStrike = cntStrike;
    }

    public int getCntBall() {
        return cntBall;
    }

    public void setCntBall(int cntBall) {
        this.cntBall = cntBall;
    }

    public boolean isNothing() {
        return isNothing;
    }

    public void setNothing(boolean nothing) {
        isNothing = nothing;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public boolean isRestart() {
        return isRestart;
    }

    public void setRestart(boolean restart) {
        isRestart = restart;
    }

    public boolean isEndGame() {
        return isEndGame;
    }

    public void setEndGame(boolean endGame) {
        isEndGame = endGame;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public void setError(boolean error, String message) {
        this.isError = error;
        this.message = message;
    }

}
