package baseball.domain;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static Computer COMPUTER;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9 ;
    private static final int NUMBER_LENGTH = 3;

    private Computer(){
    }

    public static Computer createComputer(){
        if (COMPUTER == null ){
            COMPUTER = new Computer();
        }
        return COMPUTER;
    }

    public List<String> generateRandomNumber(){
        ArrayList<String>numberList = new ArrayList<>();
        while(numberList.size()!=NUMBER_LENGTH) {
            int numberInt = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            String numberToStr = String.valueOf(numberInt);
            if(!numberList.contains(numberToStr)){
                numberList.add(numberToStr);
            }
        }
        return numberList;
    }
}
