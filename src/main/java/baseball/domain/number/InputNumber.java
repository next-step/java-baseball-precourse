package baseball.domain.number;

import java.util.*;

public class InputNumber {

    private int inputData;

    private final int MAX_LEN = 3;

    public InputNumber(String data){

        //숫자만 있는지 체크
        int inputIntValue = checkOnlyNumber(data);
        //3자리수보다 작거나 큰지?
        checkIsOnlyHundredNumber(inputIntValue);
        //서로다른 자리수인지 체크
        checkSameNumber(data);

        inputData = inputIntValue;
    }

    public int getInputNumber(){
        return this.inputData;
    }


    private void checkSameNumber(String data){
        List<Integer> numList = new ArrayList<>();

        for(int i=0; i<data.length(); i++){
            char c = data.charAt(i);
            numList.add(c - '0');
        }

        // Set 으로 변환
        Set<Integer> numSet = new HashSet<>(numList);

        if(numSet.size()!= 3){
            throw new IllegalArgumentException("3자리 숫자는 각기 다른 숫자여야 합니다!");

        }
    }

    private int  checkOnlyNumber(String data){
        try {
            return Integer.valueOf(data);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("숫자만 사용가능합니다!");
        }
    }

    private void checkIsOnlyHundredNumber(int value){
        if(value < 100 || value > 999){
            throw new IllegalArgumentException("3자리 숫자여야 합니다!");
        }
    }


}
