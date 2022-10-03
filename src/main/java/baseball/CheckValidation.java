package baseball;

import java.util.ArrayList;
import java.util.List;

public class CheckValidation {

    public static boolean sizeCheck(String inputNo,int numberSize) {
        if(inputNo.length() != numberSize){
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String inputNo) {
        try {
            Double.parseDouble(inputNo);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean numberRangeCheck(String inputNo) {
        List<Integer> numberList = ConvertUtils.StringToList(inputNo);
        for(int num : numberList){
            if(num <= 0 || num > 9){
                return false;
            }
        }
        return true;
    }
}
