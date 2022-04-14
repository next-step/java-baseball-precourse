package baseball.answer;

public class AnswerConfig {
    private AnswerConfig(){
        throw new IllegalStateException();
    }
    
    public static final int ANSWER_NUMBER_MIN = 1;
    public static final int ANSWER_NUMBER_MAX = 9;
    public static final int ANSWER_LENGTH = 3;
}