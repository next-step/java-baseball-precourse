package baseball.service;

import baseball.constant.CommonConstant;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class SystemServiceImpl implements SystemService {


    @Override
    public String setRandomNumber(int length) {
        Set<Integer> randomNums = new HashSet<>();
        randomNums = addUniqueNums(randomNums, length);

        StringBuilder stringRandomNums = new StringBuilder();
        for (Integer num : randomNums) {
            stringRandomNums.append(num);
        }
        return stringRandomNums.toString();
    }

    private Set<Integer> addUniqueNums(Set<Integer> randomNums, int length) {
        randomNums.add(getRandomNum());
        if (randomNums.size() < length) {
            addUniqueNums(randomNums, length);
        }
        return randomNums;
    }

    @Override
    public String getReadLine() {
        return Console.readLine();
    }


    private int getRandomNum() {
        return Randoms.pickNumberInRange(CommonConstant.MIN_NUM, CommonConstant.MAX_NUM);
    }
}
