package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInputView {

        //msg
        // 1. 숫자를 입력해주세요 :
        // 2. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
        private static String START_MSG = "숫자를 입력해주세요 : ";

        private static String END_CONTINUE_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


        // 게임 시작 시 숫자 입력 메소드
        public static String requireBaseBallNumber() {
                System.out.println(START_MSG);
                return Console.readLine();
        }

        // 게임 종료 후 게임 새 시작 및 종료 메소드
        public static String endGameMsg() {
                System.out.println(END_CONTINUE_MSG);
                return Console.readLine();
        }




}
