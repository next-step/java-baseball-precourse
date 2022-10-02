package baseball.domain.compare;

import baseball.game.GameResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compare {
    private int strike_cnt =0;
    private int ball_cnt =0;
    private Map<Integer, Integer> comNumTomap;
    public GameResult compareTwoNumber(int input, List<Integer> computerNumber){

        comNumTomap = new HashMap<>();

        //
        int comNum = computerNumber.get(0);
        count_randNum(comNum);//컴퓨터 수 분해
        count_compare(input);//제시 숫자 분석

        GameResult gameResult = new GameResult(strike_cnt, ball_cnt);

        return gameResult;
    }

    public void count_compare(int inputNumber) {
        String strInputNum = String.valueOf(inputNumber);
        for (int i = 0; i < strInputNum.length(); i++) {
            int num = strInputNum.charAt(i) -'0';
            checkGameCount(i, num);
        }
    }

    private void checkGameCount(int i, int num) {
        if (comNumTomap.containsKey(num)) {
            int index = comNumTomap.get(num);

            if(i == index){
                strike_cnt+=1;
                return;
            }

            if (i != index) {
                ball_cnt+=1;
                return;
            }
        }
    }


    public void count_randNum(int number){
        String strNum = String.valueOf(number);
        for(int i=0; i<strNum.length(); i++){
            char c = strNum.charAt(i);

            comNumTomap.put(c - '0', i);
        }
    }
}
