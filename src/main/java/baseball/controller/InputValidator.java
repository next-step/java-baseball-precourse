package baseball.controller;

import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * @author Lee SeungHwan <lshn1007@hanyang.ac.kr>
 * @version 1.0
 * @since 21-10-02
 */
public class InputValidator {

    private static int LENGTH_LIMIT = 3;

    public static boolean checkPipeLine(String number) {
        try{
            checkLength(number);
            checkSpace(number);
            isNumeric(number);
            checkNegative(number);
            checkDoubleNumber(number);

            return true;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }


    private static void isNumeric(String number){
        try {
            Integer.parseInt(number);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_ERR);
        }
    }

    private static void checkSpace(String number){
        String regexNumber = Pattern.compile("\\s").matcher(number).replaceAll("");
        if(!regexNumber.equals(number))
            throw new IllegalArgumentException(ErrorMessage.SPACE_ERR);
    }

    private static void checkLength(String number){
        if(number.length() != LENGTH_LIMIT)
            throw new IllegalArgumentException(ErrorMessage.LENGTH_ERR);
    }

    private static void checkNegative(String number){
        if(Integer.parseInt(number) < 0)
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_ERR);
    }

    private static void checkDoubleNumber(String number){
        List<Character> numMemberList = new ArrayList<Character>();
        Set<Character> numMemberSet = new HashSet<Character>();

        for(char elem : number.toCharArray()){
            numMemberList.add(elem);
            numMemberSet.add(elem);
        }

        if (numMemberList.size() != numMemberSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.DOUBLENUM_ERR);
        }
    }

    private static class ErrorMessage{
        public static final String NUMERIC_ERR = "[ERROR] : 숫자만 입력 가능합니다.";
        public static final String LENGTH_ERR = "[ERROR] : 3자리 숫자를 입력해주세요.";
        public static final String SPACE_ERR = "[ERROR] : 띄어쓰지 말아주세요.";
        public static final String NEGATIVE_ERR = "[ERROR] : 음수는 입력할 수 없습니다.";
        public static final String DOUBLENUM_ERR = "[ERROR] : 중복된 숫자가 있습니다.";
    }
}
