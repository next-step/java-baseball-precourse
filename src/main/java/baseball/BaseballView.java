package baseball;

import static nextstep.utils.Console.readLine;

public class BaseballView {

    static final String inputInitMessage = "숫자를 입력해주세요 : ";
    static final String inputErrorMessage = "[ERROR]잘못된 입력형식 입니다. 다시 입력해주세요. ";
    static final String GameEndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 ";

//    BaseballController baseballController = new BaseballController();

    public void playBaseball(){
        int strike = 0;
        int ball = 0;
        boolean end = false;

        while(!end){
            String inputNumber = InputNumber();

            // 입력값 출력 테스트
            System.out.println(inputNumber);

        }

        /* 3스트라이크 시 게임 종료 */
//        if(strike == 3){
//            System.out.println(GameEndMessage);
//        }





    }

    private String InputNumber(){
        System.out.print(inputInitMessage);
        return readLine();
    }


}
