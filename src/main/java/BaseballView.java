import java.util.Scanner;

public class BaseballView {
	private final Scanner scanner;
	public BaseballView() {
		scanner = new Scanner(System.in);
	}
	public void printIntro() {
		System.out.println("야구 게임을 시작합니다!");
	}

	public void printControlGuide() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public int scanControl() {
		if (scanner.hasNextInt()) {
			return scanner.nextInt();
		}
		scanner.next();
		return 0;
	}

	public void printControlError() {
		System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");
	}

	public void printResult(BaseballResult result) {
		if (result == null) {
			System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");
			return;
		}
		if (result.isNothing()) {
			System.out.println("낫싱");
			return;
		}
		if (result.getStrike() != 0) {
			System.out.printf("%d스트라이크 ", result.getStrike());
		}
		if (result.getBall() != 0) {
			System.out.printf("%d볼", result.getBall());
		}
		System.out.println();
	}

	public void printOutro() {
		System.out.println("3개의 숫자를 모두 맞췄습니다!");
	}

	public void printInputGuide() {
		System.out.print("숫자를 입력해주세요: ");
	}

	public int scanBaseballNumber() {
		if (scanner.hasNextInt()) {
			return scanner.nextInt();
		}
		scanner.next();
		return 0;
	}
}
