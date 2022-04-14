package baseball.view;

public class UserOutputView {

        //msg
        // 1. 볼
        // 2. 스트라이크
        // 3. 낫싱
        // 4. 3개의 숫자를 모두 맞히셨습니다! 게임종료
        private static final String BALL = "볼";
        private static final String STRIKE = "스트라이크";
        private static final String NOTHING = "낫싱";
        private static final String CLEAR_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

        // 게임 진행 중 해당 하는 메시지 호출
        public static void printResult(int ballCount, int strikeCount){
                System.out.println(ballCount + "볼");
                System.out.println(strikeCount + "스트라이크");

                // 볼/스트라이크 없는 경우
                if(ballCount == 0 && strikeCount == 0) {
                        System.out.println(NOTHING);

                }
        }

        // 정답을 맞춘 경우에 해당 메시지 호출
        public static void printClearMsg() {
                System.out.println(CLEAR_MSG);
        }


}
