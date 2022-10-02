package baseball.domain.computer;

import baseball.io.OutputFunction;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {

    private final List<Integer> RANDOM_NUMBER;

    private final int TOTAL_SIZE = 3;
    private final int START_VALUE = 1;
    private final int END_VALUE = 9;

    public Computer(){
        this.RANDOM_NUMBER = generatePickRndNumber();
    }

    public List<Integer> getRANDOM_NUMBER(){
        return this.RANDOM_NUMBER;
    }



    public List<Integer> generatePickRndNumber(){
        validateRange(START_VALUE, END_VALUE);
        int rndNum=0;

        Set<Integer> rightRndNum = new LinkedHashSet<>();
        List<Integer> pickedRndNumber = new ArrayList<>();
        while (rightRndNum.size() < TOTAL_SIZE) {
            rndNum  = Randoms.pickNumberInRange(1, 9);
            rightRndNum.add(rndNum);
        }

        Iterator<Integer> iterator = rightRndNum.iterator();
        String strRndNum="";
        while (iterator.hasNext()) {
            strRndNum += String.valueOf(iterator.next());
        }

        pickedRndNumber.add(Integer.parseInt(strRndNum));
        return pickedRndNumber;
    }


    private void validateRange(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive cannot be greater than endInclusive.");
        }
        if (endInclusive == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("endInclusive cannot be greater than Integer.MAX_VALUE.");
        }
        if (endInclusive - startInclusive >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("the input range is too large.");
        }
    }



}
