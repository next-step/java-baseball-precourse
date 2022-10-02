package baseball.domain;

import static baseball.domain.Status.*;

import java.util.Objects;

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



	@Override
	public String toString() {
		return "BaseBallNumber{" +
			"position=" + position +
			", value=" + value +
			", status=" + status +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BaseBallNumber that = (BaseBallNumber)o;
		return Objects.equals(position, that.position) && Objects.equals(value, that.value)
			&& status == that.status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position, value, status);
	}
}
