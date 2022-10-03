package baseball;

import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        baseballStart();
    }

    private static void baseballStart() {
        String isContinue;
        do {
            Fitch fitch = new Fitch();
            fitchJudge(fitch);

            isContinue = inputContinueOrExit();
        } while(isContinue.equals("1"));
    }

    private static void fitchJudge(Fitch fitch) {
        int strikeCount = 0;

        while (strikeCount != 3){
            String inputNumbersString = inputThreeNumber();
            Map<String, Integer> countBallAndStrike = fitch.countBallAndStrike(inputNumbersString);

            strikeCount = printBallAndStrikeAndReturnStrike(countBallAndStrike);
        }
    }

    private static String inputThreeNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String inputString = readLine();

        if (inputString.length() != 3) {
            throw new IllegalArgumentException();
        }

        return inputString;
    }

    private static String inputContinueOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = readLine();

        if (!inputString.equals("1") && !inputString.equals("2")) {
            throw new IllegalArgumentException();
        }
        return inputString;
    }

    private static int printBallAndStrikeAndReturnStrike(Map<String, Integer> ballStrikeCountMap) {
        int ballCount = ballStrikeCountMap.getOrDefault("ball", 0);
        int strikeCount = ballStrikeCountMap.getOrDefault("strike", 0);

        if (ballCount > 0) System.out.print(ballCount + "볼 ");
        if (strikeCount > 0) System.out.print(strikeCount +"스트라이크");
        if (ballCount == 0 && strikeCount == 0) System.out.print("낫싱");
        System.out.println();

        return strikeCount;
    }
}

