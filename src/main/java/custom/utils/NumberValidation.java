package custom.utils;

public class NumberValidation {
    /**
     * 숫자 유효성 검사하는 api
     */
    NumberValidation(){

    }

    public static boolean isdigitsOfLength(String numStr, int length){
        if(numStr.length() != length){
            Message.printError("입력한 자릿수가 "+length+"자리가 아닙니다.");
            return false;
        }
        return true;
    }

    public static boolean containOnlyNumber(String numStr){
        if(!numStr.matches("^[1-9]+$")){
            Message.printError("0 또는 숫자가 아닌 문자가 포함되었습니다.");
            return false;
        }
        return true;
    }

    public static boolean haveNoDuplicateNumbers(String userNum){
        boolean[] numSet = new boolean[9];
        for(int i =0; i<3; i++){
            boolean haveNum = numSet[userNum.charAt(i) - '0'];
            if(haveNum){
                Message.printError("중복된 숫자가 입력되었습니다.");
                return false;
            }
            haveNum = true;
        }
        return true;
    }
}
