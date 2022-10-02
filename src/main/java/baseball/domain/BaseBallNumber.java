package baseball.domain;

import static baseball.domain.Status.*;

public class BaseBallNumber {

	private final Integer position;
	private final Integer value;
	private Status status;

	public Status currentStatus() {
		return status;
	}

	public boolean isCurrentStrike(){
		return status==STRIKE;
	}
	public static BaseBallNumber of(int position,int value) {
		return new BaseBallNumber(position,value);
	}
	private BaseBallNumber(int position,int value) {
		this.position = position;
		this.value = value;
	}

	public boolean isStrike(BaseBallNumber baseBallNumber) {
		return value.equals(baseBallNumber.value)
			&& position.equals(baseBallNumber.position);
	}

	public boolean isBall(BaseBallNumber baseBallNumber) {
			return status!=STRIKE
				&& value.equals(baseBallNumber.value)
				&& !position.equals(baseBallNumber.position);
	}

	public boolean isNothing(BaseBallNumber baseBallNumber) {
		return status==null&&!value.equals(baseBallNumber.value);
	}

	public void updateBallCount(BaseBallNumber baseBallNumber) {
		if(this.isNothing(baseBallNumber)){
			status = NOTHING;
		}
		if(this.isBall(baseBallNumber)){
			status = BALL;
		}
		if(this.isStrike(baseBallNumber)){
			status = STRIKE;
		}
	}

	@Override
	public String toString() {
		return "BaseBallNumber{" +
			"position=" + position +
			", value=" + value +
			", status=" + status +
			'}';
	}


}
