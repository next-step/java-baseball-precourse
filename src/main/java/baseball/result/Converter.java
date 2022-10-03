package baseball.result;

import baseball.constants.Regex;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public List<Integer> stringToIntegerList(String parseTarget) {
        String[] stringArray = parseTarget.split(Regex.SPLIT_REGEX);
        List<Integer> result = new ArrayList<>();
        for(String playerNumberText: stringArray) {
            result.add(Integer.parseInt(playerNumberText));
        }
        return result;
    }
}
