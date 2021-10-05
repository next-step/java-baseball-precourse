package baseball;

import nextstep.utils.Console;

public class View {

    public static String enterInput() {
        String input;
        do {
            System.out.println("숫자를 입력해주세요 : ");
            input = Console.readLine();
        }while (!Validator.confirmInput(input));
        return input;
    }

    public static void printScore(Record record) {
        if (record.ball == 0 && record.strike == 0) {
            System.out.println("낫싱");
            return;
        }
        renderScore(record);
    }

    private static void renderScore(Record record) {
        StringBuilder stringBuilder = new StringBuilder();
        if (record.strike != 0) {
            stringBuilder.append(record.strike).append("스트라이크 ");
        }
        if (record.ball != 0) {
            stringBuilder.append(record.ball).append("볼");
        }
        System.out.println(stringBuilder.toString());
    }

    public static boolean askOfIsEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝\n. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        while (!("1".equals(input) || "2".equals(input))) {
            System.out.println("잘못입력하셨습니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
        }
        return "2".equals(input);
    }
}
