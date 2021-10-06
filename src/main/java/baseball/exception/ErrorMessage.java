package baseball.exception;

public class ErrorMessage {

	public static String errMsgMaker(String message) {
		return String.format("[ERROR]%s", message);
	}
}
