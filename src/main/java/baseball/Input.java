package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private Input() {
    }

    public static List<Integer> inputNumbers() {
        List<Integer> inputs = new ArrayList<>();
        try {
            for (String sNumber : Console.readLine().split("")) {
                inputs.add(Integer.parseInt(sNumber));
            }
            return inputs;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
