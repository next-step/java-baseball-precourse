package baseball.model;
import nextstep.utils.Randoms;

import java.util.HashSet;

public class BaseballNumber {
    private int number;

    public BaseballNumber(){
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(){
        int computerNumber = 0;
        HashSet<Integer> numberList = new HashSet<Integer>();
        for(int i=0;i<3;i++){
            int pickedNumber = pickRandomNumber(numberList);
            computerNumber += pickedNumber;
            numberList.add(pickedNumber);
        }
        number = computerNumber;
    }

    public int pickRandomNumber(HashSet<Integer>numberList){
        int pickedNumber = Randoms.pickNumberInRange(1,9);
        while(numberList.contains(pickedNumber)){
            pickedNumber = Randoms.pickNumberInRange(1,9);
        }
        return pickedNumber;
    }
}
