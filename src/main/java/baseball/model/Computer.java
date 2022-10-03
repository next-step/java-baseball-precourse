package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Constant.INPUT_SIZE;

public class Computer {
    private final List<Integer> numbers;

    public Computer(){
        numbers = new ArrayList<>(INPUT_SIZE);

        while(numbers.size() < 3){
            int generatedRandomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(generatedRandomNumber)){
                numbers.add(generatedRandomNumber);
            }
        }
    }

    public int getSize(){
        return numbers.size();
    }

    public int getValue(int index){
        return numbers.get(index);
    }

    public boolean contains(int value){
        return numbers.contains(value);
    }
}
