package baseball.view;

public class Output {
	public static void printInputNumberMessage() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public static void printEndOfGameMessage() {
		System.out.println("3개의숫자를모두맞히셨습니다! 게임 끝");
	}

	public static void printExceptionMessage(String message) {
		StringBuffer buffer = new StringBuffer();
		buffer
			.append("[ERROR]")
			.append(message);
		System.out.println(buffer.toString());
	}

	public static void printGameResult(String result){
		System.out.println(result);
	}

	public static void printRestartOrStopMessage(){
		System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
	}
}
