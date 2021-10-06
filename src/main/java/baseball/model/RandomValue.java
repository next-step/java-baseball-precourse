package baseball.model;

import nextstep.utils.Randoms;

/**
 * 컴퓨터에서 설정하는 랜덤넘버 모델
 * @author mac
 *
 */
public class RandomValue {
	private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int ONES_PLACE = 1;
    private static final int TENS_PLACE = 10;
    private static final int HUNDREDS_PLACE = 100;
    
	/**
	 *  램덤 3자리생성
	 */
	public static int makeRandomValue() {

		int firstTargetNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

		int secondTargetNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		while (firstTargetNumber == secondTargetNumber) {
			secondTargetNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		}

		int thirdTargetNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		while ((firstTargetNumber == thirdTargetNumber) || (secondTargetNumber == thirdTargetNumber)) {
			thirdTargetNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		}

		return ((firstTargetNumber * HUNDREDS_PLACE) + (secondTargetNumber * TENS_PLACE)
				+ (thirdTargetNumber * ONES_PLACE));
	}
		
}
