package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class ComputerRandomNumber {
        // random num array 생성
        // camp.nextstep.edu.missionutils.Randoms
        // pickNumberInRange() 활용하여 랜덤숫자 3개를 생성하여 담는다.
        // Computer class 생성

        // 1 ~ 9의 숫자의 야구게임
        private static final int START = 1;
        private static final int END = 9;
        // 랜덤숫자 3개 제한
        private static final int COUNT = 3;

        // 생성된 랜덤 숫자
        private static int num;

        // 랜덤 숫자 담을 리스트
        ArrayList<Integer> randomNum = new ArrayList<Integer>();

        public ArrayList<Integer> RandomNum(){

                // COUNT 갯수 만큼 랜덤 숫자 생성.
                while(randomNum.size() < COUNT){
                    num = Randoms.pickNumberInRange(START, END);
                    RandomDuplicationCheck();
                }
                return randomNum;
        }

        // 숫자 중복 체크
        private void RandomDuplicationCheck (){
                if(!randomNum.contains(num)){
                    randomNum.add(num);
                }
        }
}
