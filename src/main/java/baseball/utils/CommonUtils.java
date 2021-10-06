package baseball.utils;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CommonUtils{
    public static List<Integer> stringToIntegerList(String readLine, int minNumber, int maxNumber){
        String[] splitList = readLine.replaceAll("\\s", "").split("");
        List<String> list = new ArrayList<>(Arrays.asList(splitList));
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            resultList.add(ValidateUtils.StringToNumber(list.get(i), minNumber, maxNumber));
        }
        return resultList;
    }

    public static List<Integer> createRandomList(int gameNumberDigits, int minNumber, int maxNumber){
        List<Integer> resultList = new ArrayList<>();
        HashSet<Integer> randomList = new HashSet<>();
        while (randomList.size() < gameNumberDigits){
            randomList.add(Randoms.pickNumberInRange(minNumber,maxNumber));
        }
        for (Integer number : randomList) {
            resultList.add(number);
        }
        return resultList;
    }

}
