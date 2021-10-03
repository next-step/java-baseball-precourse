package baseball;

import static nextstep.utils.Console.readLine;
import static nextstep.utils.Randoms.pickNumberInRange;

public class Baseball {
    boolean gameEndFlag = false;

    public void startGame() {
        gameEndFlag = false;
        char[] gameNumber = generateNumber();
//        System.out.println("정답 숫자 : " + gameNumber);

        while(!gameEndFlag){
            System.out.println("숫자를 입력해주세요 : ");
            String result = checkNumber(gameNumber, inputNumber());
            System.out.println(result);

            if (result.equals("3스트라이크 ")) gameEndFlag = true;
        }
    }

    //    컴퓨터는 1에서9까지 서로 다른 임의의 수 3개를 선택한다.
    public char[] generateNumber(){
        char[] gameNumber = new char[3];
        for (int i = 0; i < 3; i++) {
            gameNumber[i] = Integer.toString(pickNumberInRange(1, 9)).charAt(0);
        }
        return gameNumber ;
    }

    //    기본적으로1부터9까지서로다른수로이루어진3자리의수를맞추는게임이다.
    public char[] inputNumber(){
        return readLine().toCharArray();
    }

    //    같은수가같은자리에있으면스트라이크,다른자리에있으면볼,같은수가전혀없으면포볼또는낫싱
    public String checkNumber( char[] gameNumberArray,  char[] inputNumberArray){
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < gameNumberArray.length; i++) {
            if (gameNumberArray[i] == inputNumberArray[i]) {
                strike++;
                continue;
            }
            if (gameNumberArray.toString().contains(String.valueOf(inputNumberArray[i])))
                ball++;
        }
        return makeResultString(strike, ball);
    }

    public String makeResultString(int strike, int ball){
        String result = "낫싱";
        if(strike> 0) result = strike + "스트라이크 ";
        if(ball> 0) result = result  + ball + "볼";
        return result;
    }

    //    게임을종료한후게임을다시시작하거나완전히종료할수있다.
    public boolean endGame(){
        return true;
    }
}
