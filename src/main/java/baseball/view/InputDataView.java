package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputDataView {

    public String inputDataScanner(String explain) {
        System.out.print(explain);
        return Console.readLine();
    }
}