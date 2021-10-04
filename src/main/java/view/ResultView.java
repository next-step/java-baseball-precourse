package view;

import baseball.PlayResult;
import baseball.Status;

import java.util.Map;

public class ResultView {
    public static void printResult(PlayResult playResult) {
        for (Map.Entry<Status, Integer> entry : playResult.resultGame().entrySet()) {
            System.out.print(entry.getValue() + "" + entry.getKey().statusName + " ");
        }
    }
}
