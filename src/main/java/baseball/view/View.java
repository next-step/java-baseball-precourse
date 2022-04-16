package baseball.view;

import baseball.model.Result;

public class View {
    public static void result(Result result) {
        StringBuilder builder = new StringBuilder();
        if (result.getBall() > 0)
            builder.append(result.getBall()).append("볼 ");
        if (result.getStrike() > 0)
            builder.append(result.getStrike()).append("스트라이크");
        String temp = builder.toString();

        String output = temp.length() > 0 ? temp : "낫싱";
        System.out.println(output);
    }

    public static void answer() {
        System.out.print("3개의 숫자 모두 맞히셨습니다!");
        System.out.println("게임 종료");
    }

    public static void restart() {
        System.out.println("게임을 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
