package baseball.util;

import baseball.domain.JudgementResult;

public class Printer {
    private Printer() {

    }

    public static void print(String sentence) {
        System.out.print(sentence);
    }

    public static void println(String sentence) {
        System.out.println(sentence);
    }

    public static void printJudgementResult(JudgementResult judgementResult) {
        System.out.println(judgementResult);
    }
}
