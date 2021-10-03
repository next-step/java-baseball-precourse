package baseball;

import baseball.Constants.ResultEnum;

/**
 * 입력 시도 결과 클래스
 * @author Lee JeongHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class TryResult {

	private static final String NOTHING_STR = "낫싱";
	private static final String STRIKE_STR = "스트라이크";
	private static final String BALL_STR = "볼";
	private static final String WIN = "승리";
	private static final int MAX_COUNT = 3;

	private int strikeCount;
	private int ballCount;
	private boolean isWin;

	public TryResult() {
		this.strikeCount = 0;
		this.ballCount = 0;
		this.isWin = false;
	}

	public boolean isWin() {
		return isWin;
	}

	public void addResultEnum(ResultEnum result) {
		if(result.equals(ResultEnum.STRIKE)) {
			strikeCount++;
		}
		if(strikeCount == 3) {
			isWin = true;
		}
		if(result.equals(ResultEnum.BALL)) {
			ballCount++;
		}
	}

	/**
	*  입력된 3개의 결과를 통해 메세지 출력
	* */
	@Override
	public String toString() {
		if(strikeCount+ballCount == 0){
			return NOTHING_STR;
		}
		if(strikeCount == 3) {
			return WIN;
		}
		String result = "";
		if(strikeCount > 0) {
			result += strikeCount +" "+ STRIKE_STR;
		}
		if(strikeCount > 0 && ballCount > 0) {
			result += " ";
		}
		if(ballCount > 0) {
			result += ballCount +" "+ BALL_STR;
		}
		return result;
	}

}
