package baseball.core.model.player;

import camp.nextstep.edu.missionutils.Console;

public class TestHitter implements Hitter {

    private static TestHitter testHitter = null;
    public static String hits;

    private TestHitter() {
    }

    public synchronized static TestHitter getInstance() {
        if (testHitter == null) {
            testHitter = new TestHitter();
        }
        return testHitter;
    }

    @Override
    public void hitting() {
        System.out.print("숫자를 입력해주세요 : ");
        hits = Console.readLine();
        validation(hits);
    }

    @Override
    public void validation(String hit) {
        if (hit.length() != 3) {
            System.err.println("invalid input length");
            throw new IllegalArgumentException();
        }

        if (hit.contains("0")) {
            System.err.println("0 is not included");
            throw new IllegalArgumentException();
        }

        if (hit.charAt(0) == hit.charAt(1) || hit.charAt(1) == hit.charAt(2) || hit.charAt(0) == hit.charAt(2)) {
            System.err.println("Duplicate numbers are not allowed");
            throw new IllegalArgumentException();
        }

        int hitNum = Integer.parseInt(hit);
        if (hitNum < 100 || hitNum > 999) {
            throw new IllegalArgumentException();
        }


    }

    @Override
    public String getHits() {
        return hits;
    }
}
