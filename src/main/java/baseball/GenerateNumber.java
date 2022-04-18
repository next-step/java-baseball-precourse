package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateNumber {

    private static int startInclusive = 1;
    private static int endInclusive = 9;
    private static int digit = 3;
    private List<Integer> randoms;

    public List<Integer> generate() {
        this.randoms = new ArrayList<>();
        for(int i = 0 ; i < this.digit; i++) {
            this.randoms.add(pickUniqueNumber());
        }
        return this.randoms;
    }

    private int pickUniqueNumber() {
        boolean isDuplicate;
        int randomCandidate;
        do{
            randomCandidate = Randoms.pickNumberInRange(this.startInclusive, this.endInclusive);
            isDuplicate = checkNumberIsDuplicate(randomCandidate);
        }while(isDuplicate);

        return randomCandidate;
    }

    private boolean checkNumberIsDuplicate(int randomCandidate) {
        return this.randoms.contains(randomCandidate);
    }

}