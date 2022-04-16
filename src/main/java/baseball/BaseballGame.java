package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {

    public static void start() {
        boolean start = true;

        while (start) {
            Computer computer = new Computer();
            computer.throwAutoThreeTimes(); // TODO : Computer 클래스의 main() 메서드로 만들 수 있을까?

            boolean result = init(computer);
            start = result;
        }
        terminate();

    }

    public static boolean init(Computer computer) {
        boolean ThreeStrike = false;
        while (!ThreeStrike) {
            Player player = new Player();
            player.drawNumbers();
            System.out.println("컴퓨터 : " + computer.inputs);
            CalculateCounts calculate = new CalculateCounts();
            ThreeStrike = calculate.compareEach(computer.inputs, player.inputs);
        }
        return retry();
    }

    // TODO : Enum 추가
    // TODO : println() 하드코딩 치환
    private static boolean retry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        String continueFlag = readLine();

        if (continueFlag.equals("1")) {
            System.out.println("게임을 다시 시작합니다.");
            return true;
        }

        if (continueFlag.equals("2")) {
            System.out.println("게임 종료");
            return false;
        }

        throw new IllegalArgumentException();
    }

    public static void terminate() {
        System.out.println("게임을 종료합니다.");
        return;
    }
}
