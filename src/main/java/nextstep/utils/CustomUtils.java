package nextstep.utils;

import java.util.ArrayList;
import java.util.List;

public class CustomUtils {

    //숫자내에 중복숫자가 있는지체크
    public static boolean chkSameNum(int number) {
        boolean flag = false;

        String numText = String.valueOf(number);
        if("null".equals(numText)){
            return flag;
        }

        List<String> tmpList = new ArrayList<String>();
        for (String tmpStr : numText.split("")){
            if(!tmpList.contains(tmpStr)){
                tmpList.add(tmpStr);
            }
        }

        if(tmpList.size() == numText.length()){
            flag = true;
        }

        return flag;
    }
}
