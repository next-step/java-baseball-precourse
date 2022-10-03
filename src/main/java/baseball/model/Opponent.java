package baseball.model;

import baseball.utils.Constants;
import camp.nextstep.edu.missionutils.Randoms;

public class Opponent {
	private String missionNum = "";

	public Opponent() {
		makeMissionNum();
	}

	private void makeMissionNum() {
		while (missionNum.length() < Constants.RAND_NUM_SIZE) {
			String n = Integer.toString(Randoms.pickNumberInRange(Constants.RAND_NUM_MIN, Constants.RAND_NUM_MAX));
			missionNum = missionNum.contains(n) ? missionNum : missionNum+n;
		}
	}

	public String getMissionNum() {
		return missionNum;
	}
}
