package baseball;

import static baseball.GameMessage.*;

/**
 * @author garden.iee
 */
public class View {

	public static void printRequest() {
		System.out.print(PRINT_REQUEST.getMessage());
	}

	public static void printFinish() {
		System.out.println(FINISH.getMessage());
	}

	public static void printRestartOrFinish() {
		System.out.println(RESTART_OR_FINISH.getMessage());
	}

	public static void printHint(HintService hint) {
		System.out.println(hint.toString());
	}
}