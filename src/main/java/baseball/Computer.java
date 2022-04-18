package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> randomNums = new ArrayList<>();
    List<Integer> setNums = new ArrayList<>();
    String randomNum = "";

    public void randomNum() {
        randomNum = "";
        randomNums = new ArrayList<>();
        setNums = new ArrayList<>();
        while (randomNums.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9); // 1~9까지
            if (!randomNums.contains(num)) {
                randomNums.add(num);
                setNums.add(num);
                randomNum += num;
            }
        }
    }
}
