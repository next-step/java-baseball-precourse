package baseball.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonUtils{
    public static List<Integer> stringToIntegerList(String readLine){
        String[] splitList = readLine.replaceAll("\\s", "").split("");
        List<String> list = new ArrayList<>(Arrays.asList(splitList));
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            resultList.add(ValidateUtils.StringToNumber(list.get(i)));
        };
        return resultList;
    }
}
