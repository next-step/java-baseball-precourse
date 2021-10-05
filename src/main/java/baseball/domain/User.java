package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class User {

    public void challenge(List<Integer> inputList) {
        if(inputList.size()>0){
            System.out.println(Arrays.toString(inputList.toArray()));
        }
    }
}
