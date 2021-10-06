package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.*;

public class Application {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int ANSWER_LENGTH = 3;
    private static final String USER_INPUT_REGEX = "^["+ MIN_RANGE + "-" + MAX_RANGE + "]" + "{" + ANSWER_LENGTH + "," + ANSWER_LENGTH + "}" + "$";

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        // 문제 생성 (문제 길이, 최소값, 최대값 설정)
        String answer = createAnswer();

        // 문제 맞추기
        BallCounter ballCounter = new BallCounter();
        while(ballCounter.getStrike() < 3) {
            // 정답 입력 받기 (예외 처리 포함)
            String userInput = getUserInput();

            // 결과 판독하기
            ballCounter = countBallAndStrike(answer, userInput);

            // 결과 출력
            printCount(ballCounter);

        }

    }


    /**
     * 문제 생성 메소드입니다.
     * @return 최소 최대 설정값 범위 내 중복되지 않는 숫자로 구성된 설정값 길이만큼의 문자열을 반환합니다.
     */
    private static String createAnswer() {
        Set<Integer> answerSet = new LinkedHashSet<>();
        while (answerSet.size() < ANSWER_LENGTH) {
            answerSet.add(Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE));
        }
        String answer = "";
        for (Integer integer : answerSet) {
            answer += integer;
        }
        return answer;
    }

    /**
     * 볼, 스트라이크 결과를 관리하는 클래스
     */
    public static class BallCounter {
        private int ball;
        private int strike;

        public int getBall() {
            return ball;
        }

        public void setBall(int ball) {
            this.ball = ball;
        }

        public int getStrike() {
            return strike;
        }

        public void setStrike(int strike) {
            this.strike = strike;
        }
    }

    /**
     * 사용자 입력을 받는 메소드입니다.
     * @return 유효한 사용자 입력값 문자열을 반환합니다.
     */
    private static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        Set<Character> userInputSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            userInputSet.add(userInput.charAt(i));
        }
        boolean duplicateInput = userInputSet.size() < userInput.length();
        boolean matches = userInput.matches(USER_INPUT_REGEX);
        return processAfterUserInputValidation(userInput, duplicateInput, matches);
    }

    /**
     * 사용자 입력에 대한 유효성 검증을 수행하는 메소드입니다.
     * @param userInput 사용자 입력 문자열입니다.
     * @param duplicateInput 사용자 입력 내 중복값 존재 여부입니다.
     * @param matches 범위 내 입력 여부입니다.
     * @return 유효한 문자열을 반환합니다.
     */
    private static String processAfterUserInputValidation(String userInput, boolean duplicateInput, boolean matches) {
        if(duplicateInput) {
            System.out.println("[ERROR] : 중복 없이 입력해주세요 :)");
            return getUserInput();
        } else if(!matches){
            System.out.println("[ERROR] : " + MIN_RANGE + " ~ " + MAX_RANGE + "사이의 숫자 " + ANSWER_LENGTH + "개를 입력해주세요.");
            return getUserInput();
        }
        return userInput;
    }

    /**
     * 사용자의 입력을 받아 볼, 스트라이크 판정 결과를 반환합니다.
     * @param answer 주어진 문제 문자열
     * @param userInput 사용자 입력 문자열
     * @return 판정 결과를 담은 BallCounter 객체
     */
    private static BallCounter countBallAndStrike(String answer, String userInput) {
        BallCounter ballCounter = new BallCounter();
        String[] answerSplit = answer.split("");
        String[] userInputSplit = userInput.split("");
        for (int i = 0; i < answerSplit.length; i++) {
            boolean isStrike = answerSplit[i].equals(userInputSplit[i]);
            boolean isBall = !isStrike && answer.contains(userInputSplit[i]);
            ballCounter.setBall(isBall ? ballCounter.getBall() + 1 : ballCounter.getBall());
            ballCounter.setStrike(isStrike ? ballCounter.getStrike() + 1 : ballCounter.getStrike());
        }
        return ballCounter;
    }

    /**
     * 사용자 입력에 따른 볼, 스트라이크 결과를 출력하는 메소드입니다.
     * @param ballCounter 볼, 스트라이크 결과를 담은 BallCounter 객체가 필요합니다.
     */
    private static void printCount(BallCounter ballCounter) {
        int ball = ballCounter.getBall();
        int strike = ballCounter.getStrike();

        StringBuilder resultMessageBuilder = new StringBuilder();
        resultMessageBuilder.append(strike > 0 ? strike + "스트라이크 " : "");
        resultMessageBuilder.append(ball > 0 ? ball + "볼" : "");
        resultMessageBuilder.append(ball == strike && ball == 0 ? "낫싱" : "");
        System.out.println(resultMessageBuilder);
    }

}
