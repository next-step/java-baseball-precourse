package baseball;

import static baseball.constants.MessageConstant.*;

import java.util.ArrayList;
import java.util.List;

import baseball.constants.ResultEnum;

/**
 * 입력 시도 결과 클래스
 * @author Lee JeongHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class TryResult {

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

	/**
	 * 입력된 숫자마다 각 결과를 입력하는 메소드
	 *
	 * @param result 각 문자의 매칭여부의 결과
	 */
	public void addResultEnum(ResultEnum result) {
		if (result.equals(ResultEnum.STRIKE)) {
			strikeCount++;
		}
		if (strikeCount == 3) {
			isWin = true;
		}
		if (result.equals(ResultEnum.BALL)) {
			ballCount++;
		}
	}

	/**
	 *  입력된 3개의 결과를 통해 메세지 출력
	 * @return 결과에 따라 힌트 또는 승리 메세지 제공
	 * */
	@Override
	public String toString() {
		if (isWin) {
			return WIN_MESSAGE;
		}
		if (strikeCount > 0 || ballCount > 0) {
			return getHint();
		}
		return NOTHING_MESSAGE;
	}

	/**
	 * 힌트 문구 생성
	 * @return 힌트 문구 생성
	 * */
	public String getHint() {
		List<String> list = new ArrayList<>();
		if (strikeCount > 0) {
			list.add(strikeCount + " " + STRIKE);
		}
		if (ballCount > 0) {
			list.add(ballCount + " " + BALL);
		}
		return String.join(" ", list);
	}

}
