package baseball.model;
import nextstep.utils.Randoms;

import java.util.HashSet;

public class BaseballNumber {
    public static int number;

    public BaseballNumber(){
        this.number = setNumber();
    }

    public int getNumber(){
        return this.number;
    }

    public int setNumber(){
        int computerNumber = 0;
        HashSet<Integer> numberList = new HashSet<Integer>();
        for(int i=0;i<3;i++){
            int pickedNumber = pickRandomNumber(numberList);
            computerNumber += pickedNumber*Math.pow(10,i);
            numberList.add(pickedNumber);
        }
        this.number = computerNumber;
        return number;
    }

    public static int pickRandomNumber(HashSet<Integer>numberList){
        int pickedNumber = Randoms.pickNumberInRange(1,9);
        while(numberList.contains(pickedNumber)){
            pickedNumber = Randoms.pickNumberInRange(1,9);
        }
        return pickedNumber;
    }
}
