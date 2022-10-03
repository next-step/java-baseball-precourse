package baseball.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class StandardInput implements Input {

    @Override
    public List<Integer> userPickNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String[] numbersToken = Console.readLine().split("");
        List<Integer> numberList = new ArrayList<>();
        for (String number : numbersToken) {
            numberList.add(Integer.parseInt(number));
        }
        return numberList;
    }

    @Override
    public int wantRetry() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }
}
