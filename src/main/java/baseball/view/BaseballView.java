package baseball.view;

public class BaseballView {
	private static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요: ";
	private static final String ERROR_MESSAGE = "[ERROR] 올바른 숫자를 입력해주세요. 중복된 숫자가 없는 세 자리 자연수를 입력해야 합니다.";

	public void showRequestInputMessage() {
		System.out.printf(REQUEST_INPUT_MESSAGE);
	}

	public void showErrorMessage() {
		System.out.println(ERROR_MESSAGE);
	}
}
