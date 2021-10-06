package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String RESTART = "1";
    private static final String END = "2";
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        String randomNumber;
        String restartOrEnd = RESTART;

        //- 루프 시작
        //- 메인 종료 / 게임 재시작 분기
        while(isPlayable(restartOrEnd)) {
            //- 랜덤숫자 생성
            randomNumber = getRandomNumberString();
            System.out.printf("게임을 시작합니다. randomNumbers : %s\r\n", randomNumber);
            onGaming(randomNumber);
            restartOrEnd = selectRestartOrEndGame();
        }

        System.out.println("게임을 종료합니다.");
    }




    public static void onGaming(String randomNumber) {
        String userInput;
        boolean isDone = false;
        while(!isDone) {

            //- 사용자 입력
            userInput = getUserInputNumber();

            List<String> randomNumberList = Arrays.asList(randomNumber.split(""));
            List<String> userInputList = Arrays.asList(userInput.split(""));

            // TODO Collection.forEach 사용
            //- 조건분기
            int strikes = 0;
            int balls = 0;
            for (int i = 0; i < randomNumberList.size(); i++) {
                //- 같은 숫자 포함, 위치 동일 : 스트라이크
                strikes += countStrike(randomNumberList.get(i), userInputList.get(i));
                for (int j = 0; j < userInputList.size(); j++) {
                    //- 같은 숫자 포함, 위치 다름 : 볼
                    balls += countBalls(randomNumberList.get(i), userInputList.get(j), i!=j);
                }
            }

            //- 매 입력마다 위 결과 출력
            printStrikesAndBalls(strikes, balls);

            //- 모든 숫자 및 위치 동일하면 게임 종료
            isDone = userInput.equals(randomNumber);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
    public static void printStrikesAndBalls(int strikes, int balls) {
        if (strikes + balls == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikes > 0) {
            System.out.printf("%d스트라이크 ", strikes);
        }
        if (balls > 0) {
            System.out.printf("%d볼 ", balls);
        }
        System.out.println();
    }
    public static int countStrike(String r, String u) {
        return r.equals(u) ? 1 : 0;
    }
    public static int countBalls(String r, String u, boolean isNotSameIndex) {
        return isNotSameIndex && r.equals(u) ? 1 : 0;
    }
    public static String getUserInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        System.out.println(input);
        //- 예외처리
        if (!isCorrectNumber(input)) {
            System.out.println("[ERROR]1~9 까지의 숫자 세자리만 입력 가능합니다.");
            return getUserInputNumber();
        }
        return input;
    }
    public static Boolean isCorrectNumber(String str) {
        return str.matches("[1-9]{3}");
    }


    
    //TODO 서로 다른 3개의 숫자 뽑기
    public static String getRandomNumberString() {
        int randomNumber = Randoms.pickNumberInRange(111, 999);
        if (randomNumber % 10 == 0) {
            randomNumber += 1;
        }
        return Integer.toString(randomNumber);
    }
    public static Boolean isEmptyString(String str) {
        return str == null || str.isEmpty() || str.trim().isEmpty();
    }





    public static boolean isPlayable(String str) {
        if (str.equals(RESTART)) {
            return true;
        }
        if (str.equals(END)) {
            return false;
        }

        return isPlayable(selectRestartOrEndGame());
    }
    public static String selectRestartOrEndGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartOrEndGame = Console.readLine();
        if (restartOrEndGame.equals(RESTART)) {
            return RESTART;
        }
        if (restartOrEndGame.equals(END)) {
            return END;
        }
        return selectRestartOrEndGame();
    }

}
