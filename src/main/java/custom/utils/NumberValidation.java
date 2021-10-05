package custom.utils;

public class NumberValidation {
    /**
     * 숫자 유효성 검사하는 api
     */
    NumberValidation(){

    }

    public static boolean is3digitsOfLength(String numStr){
        if(numStr.length() != 3){
            Message.printError("입력한 자릿수가 3자리가 아닙니다.");
            return false;
        }
        return true;
    }

    public static boolean containOnlyNumber(String numStr){
        if(!numStr.matches("^[1-9]+$")){
            Message.printError("숫자가 아닌 문자가 포함되었습니다.");
            return false;
        }
        return true;
    }

    public static boolean haveNoDuplicateNumbers(String userNum){
        boolean[] numSet = new boolean[9];
        for(int i =0; i<3; i++){
            if(numSet[userNum.charAt(i) - '0']){
                Message.printError("중복된 숫자가 입력되었습니다.");
                return false;
            }
            numSet[userNum.charAt(0) - '0'] = true;
        }
        return true;
    }
}
