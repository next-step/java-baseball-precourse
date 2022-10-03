package baseball.application;

import java.util.Objects;

public class ResumeOrNot {

	private final int opinion;

	public ResumeOrNot(String userReply) {
		isNullValue(userReply);
		isValidLength(userReply);

		this.opinion = userReply.charAt(0) - '0';
		isValidOpinionRange(opinion);
	}

	private void isNullValue(String userReply) {
		if (Objects.isNull(userReply)) {
			throw new IllegalArgumentException();
		}
	}

	private void isValidLength(String userReply) {
		if (userReply.length() != 1) {
			throw new IllegalArgumentException();
		}
	}

	private void isValidOpinionRange(int opinion) {
		if ((opinion != 1) && (opinion != 2)) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isResume() {
		return (opinion == 1);
	}
}
