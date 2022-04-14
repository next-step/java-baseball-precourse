package baseball.controller;

import baseball.domain.ComputerRandomNumber;
import baseball.domain.UserRandomNumber;
import baseball.exception.ValidIllegalArgumentException;
import baseball.view.UserInputView;
import baseball.view.UserOutputView;

import java.util.ArrayList;

public class baseballGameController {

        public static void run() {

                gameStart();

                endContinueCheck();
        }

        private static void endContinueCheck(){
                String checkMsg = UserInputView.endGameMsg();

                if (checkMsg.equals("1")){
                        run();
                        return;
                }

                if (checkMsg.equals("2")){
                        UserOutputView.printEndMsg();
                        return;
                }

                throw new ValidIllegalArgumentException();
        }


        private static void gameStart(){
                int strikeCount = 0;
                int ballCount = 0;

                // 컴퓨터 랜덤 숫자 클래스 생성
                ComputerRandomNumber num = new ComputerRandomNumber();

                // 생성
                ArrayList<Integer> computer = num.RandomNum();


                while (strikeCount != 3) {
                        UserRandomNumber userBaseBallNumbers = new UserRandomNumber(UserInputView.requireBaseBallNumber());
                        ballCount = userBaseBallNumbers.ballCount(computer);
                        strikeCount = userBaseBallNumbers.strikeCount(computer);
                        UserOutputView.printResult(ballCount, strikeCount);
                        System.out.println(computer);
                }
                UserOutputView.printClearMsg();
        }



}
