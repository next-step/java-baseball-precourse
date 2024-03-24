import java.util.Objects;
import java.util.Scanner;

public class BaseballController {
    private final BaseballView baseballView;
    private final Scanner scanner = new Scanner(System.in);

    public BaseballController(BaseballView baseballView) {
        this.baseballView = baseballView;
    }

    public int[] getInput() {
        while (true) {
            String input = scanner.nextLine();
            String[] splittedString = input.split("");

            if (splittedString.length != 3) {
                baseballView.printInputErrorMessage();
                continue;
            }
            try {
                return new int[]{Integer.parseInt(splittedString[0]), Integer.parseInt(splittedString[1]), Integer.parseInt(splittedString[2])};
            } catch (NumberFormatException e) {
                baseballView.printInputErrorMessage();
            }
        }
    }

    public boolean getExitOrRestartInput() {
        while (true) {
            String input = scanner.nextLine();
            if (!Objects.equals(input, "1") && !Objects.equals(input, "2")) {
                baseballView.printInputErrorMessage();
                continue;
            }

            int num = Integer.parseInt(input);

            if (num == 1) {
                return false;
            } else if (num == 2) {
                return true;
            }
        }
    }
}
