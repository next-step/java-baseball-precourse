package baseball.model;

public class BallCount {

	private static int strike;
    private static int ball;
    private static final String RESULT_NOTHING = "낫싱";
    private static final String RESULT_STRIKE = "스트라이크";
    private static final String RESULT_BALL = "볼";
    
    /**
     * 메서드 checkStrikeAndBall()은 컴퓨터가 랜덤으로 선정한 값과 플레이어가 입력한 숫자를 비교하여 결과를 볼, 스트라이크 갯수로 표시해 리턴
     * @param RandomValues 플레이어가 맞춰야 할 타깃넘버
     * @param userInputNumber 플레이어가 콘솔에 입력한 숫자
     * @return 결과에 따라 볼, 스트라이크 갯수나 낫싱을 리턴
     */
    public static String checkStrikeAndBall(int randomValues, int userInputNumber) {
        int [] targetDigits;
        targetDigits = SeparateNumber.makeArray(randomValues);
        int [] userDigits;
        userDigits = SeparateNumber.makeArray(userInputNumber);

        strike = 0;
        ball = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                updateStrikeOrBall(targetDigits[i], userDigits[j], i, j);
            }
        }

        return resultStrikeAndBall();
    }

    private static void updateStrikeOrBall(int targetDigit, int userDigit, int targetIndex, int userIndex) {
        if((targetDigit == userDigit) && (targetIndex == userIndex)) {
            strike++;
        } else if ((targetDigit == userDigit) && (targetIndex != userIndex)) {
            ball++;
        }
    }

    private static String resultStrikeAndBall() {
        String result = "";
        BallCount ballCnt = new BallCount();
        
        if ((ball == 0) && (strike == 0))
        	result = ballCnt.notingResult();  
        if ((ball != 0) && (strike == 0))
        	result = ballCnt.onlyBallCase(); 
        if ((ball == 0) && (strike != 0))
        	result = ballCnt.onlyStrikeCase(); 
        if ((ball != 0) && (strike != 0))
        	result = ballCnt.BallAndStrike(); 
      
        return result;
    }
    
    private String onlyBallCase() {
    	String result = Integer.toString(ball);
        result += RESULT_BALL;
        return result;
    }
    
    private String onlyStrikeCase() {
    	String result = Integer.toString(strike);
        result += RESULT_STRIKE;
        return result;
    }
    
    private String notingResult() {
    	return RESULT_NOTHING;
    }
    
    private String BallAndStrike() {
    	String result = "";
        result += Integer.toString(strike);
        result += RESULT_STRIKE;
        result += " ";
    	result += Integer.toString(ball);
        result += RESULT_BALL;
        result += " ";

        return result;
    }
    
}
