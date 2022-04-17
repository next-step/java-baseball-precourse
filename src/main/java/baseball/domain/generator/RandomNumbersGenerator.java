package baseball.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RandomNumbersGenerator implements Generator {
    static int MIN_NUM = 1;
    static int MAX_NUM = 9;

    @Override
    public List<Integer> generateNumbers(int size) {
        return uniqueNumberList(size);
    }

    private List<Integer> uniqueNumberList (int size){
        HashSet<Integer> checkNumbers = new HashSet<>();
        while(checkNumbers.size() < size){
            checkNumbers.add(Randoms.pickNumberInRange(MIN_NUM,MAX_NUM));
        }
        return new ArrayList<>(checkNumbers);
    }
}
