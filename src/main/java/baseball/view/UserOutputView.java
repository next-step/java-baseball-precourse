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
        private static final String END_MSG = "게임 종료";

        // 게임 진행 중 해당 하는 메시지 호출
        public static void printResult(int ballCount, int strikeCount){

                NothingMsg(ballCount,strikeCount);
                ballCountMsg(ballCount);
                strikeCountMsg(strikeCount);


                if(ballCount > 0 || strikeCount > 0){
                        System.out.print(ballCount + "볼 ");
                        System.out.println(strikeCount + "스트라이크");
                }
        }

        public static void NothingMsg(int ballCount, int strikeCount){
                // 볼/스트라이크 없는 경우
                if(ballCount == 0 && strikeCount == 0) {
                        System.out.println(NOTHING);

                }
        }

        public static void ballCountMsg(int ballCount){
                if(ballCount > 0){
                        System.out.print(ballCount + "볼 ");
                }
        }

        public static void strikeCountMsg(int strikeCount){
                if(strikeCount > 0){
                        System.out.println(strikeCount + "스트라이크");
                }
        }

        // 정답을 맞춘 경우에 해당 메시지 호출
        public static void printClearMsg() {
                System.out.println(CLEAR_MSG);
        }

        // 게임을 종료하는 경우 메시지 호출
        public static void printEndMsg() {
                System.out.println(END_MSG);
        }




}
