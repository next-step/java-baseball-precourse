import java.util.Scanner;

public class BaseballGameController {
	private final Scanner sc;
	public BaseballGameController(Scanner scan) {
		this.sc = scan;
	}

	public String readNum(int num) {
		String val = readNum();
		try {
			int valNum = Integer.parseInt(val.strip());
			if (valNum < 0) {
				return null;
			}
			if (val.length() == num) {
				return val;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	private String readNum() {
		String val;
		try {
			val = sc.next();
		} catch (Exception e) {
			val = null;
		}
		return val;
	}
}
