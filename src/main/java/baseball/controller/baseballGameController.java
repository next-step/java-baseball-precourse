package baseball.controller;

import baseball.domain.ComputerRandomNumber;
import baseball.view.UserInputView;
import baseball.view.UserOutputView;

import java.util.ArrayList;

public class baseballGameController {

        public static void run() {

                // 컴퓨터 랜덤 숫자 클래스 생성
                ComputerRandomNumber num = new ComputerRandomNumber();

                ArrayList<Integer> ConputerNum = num.RandomNum();




        }

        private static void endContinueCheck(){
                String checkMsg = UserInputView.endGameMsg();

                if (checkMsg.equals("1")){

                }

                if (checkMsg.equals("2")){
                    UserOutputView.printClearMsg();
                    return;
                }

                throw new IllegalArgumentException("1또는 2를 입력해야 합니다.");
        }



}
