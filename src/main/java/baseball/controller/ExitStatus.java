package baseball.controller;

import java.util.HashMap;
import java.util.Map;

public enum ExitStatus {
	REPLAY("1"),
	EXIT("2"),
	INVALID("INVALID");

	private static final Map<String, ExitStatus> statusMap = new HashMap<>();

	static {
		for (ExitStatus exitStatus : ExitStatus.values()) {
			statusMap.put(exitStatus.status, exitStatus);
		}
	}

	private final String status;

	ExitStatus(String status) {
		this.status = status;
	}

	/**
	 * 입력에 부합하는 status 를 갖는 ExitStatus 를 반환한다.
	 *
	 * @param input 정상적인 입력의 경우 1(REPLAY), 2(Exit) 인 문자열
	 * @return 입력의 status에 부합하는 ExitStatus
	 */
	public static ExitStatus from(String input) {
		return statusMap.getOrDefault(input, INVALID);
	}

	public boolean isReplay() {
		return this == REPLAY;
	}

	public boolean isExit() {
		return this == EXIT;
	}
}
