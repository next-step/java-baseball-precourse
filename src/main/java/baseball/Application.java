package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static String computerPickNumString = "135";

    public static void main(String[] args) {
        //computerPickNumString = Randoms.pickNumberInRange(0,999)+ "";
        computerPickNumString = "135";
        boolean whileLoopAt = true;

        while(whileLoopAt){
            System.out.print("숫자를 입력해주세요: ");
            String inputNumString = Console.readLine();
            System.out.println(inputNumString);
            String compareResult = bassballUmpire(inputNumString, computerPickNumString);
            System.out.println(compareResult);
            whileLoopAt = compareResultCheck(compareResult);
        }

    }

    static String bassballUmpire(String inputNumString, String computerPickNumString){
        if(inputNumString.length() == 0 || inputNumString.length() == 2 || inputNumString.length() > 3)throw new IllegalArgumentException();

        StringBuffer result = new StringBuffer();
        int[] resultCount = {0,0};//index0 : ball, index1: strike

        for(int index=0;index<computerPickNumString.length();index ++){
            resultCount = numStringCompare(resultCount, inputNumString, computerPickNumString, index);
        }

        if(resultCount[0] != 0)result.append(resultCount[0]+"볼");
        if(resultCount[1] != 0)result.append(" "+resultCount[1]+"스트라이크");
        if(resultCount[0] == 0 && resultCount[1] == 0)result.append("낫싱");

        return result.toString().trim();
    }

    static int[] numStringCompare(int[] resultCount, String inputNumString, String computerPickNumString, int index){
        if(inputNumString.charAt(index) == (computerPickNumString.charAt(index))){
            resultCount[1] = resultCount[1]+1;
        }else if(computerPickNumString.contains(inputNumString.charAt(index)+"")){
            resultCount[0] = resultCount[0]+1;
        }
        return resultCount;
    }

    static boolean compareResultCheck(String compareResult){
        if("3스트라이크".equals(compareResult)){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputNumString2 = Console.readLine();
            return endOrContinue(inputNumString2);
        }
        return true;
    }

    static boolean endOrContinue(String inputNumString){
        if("1".equals(inputNumString)){
            //computerPickNumString = Randoms.pickNumberInRange(0,999)+ "";
            computerPickNumString = "589";
            return true;
        }else if("2".equals(inputNumString)){
            System.out.println("게임 종료");
            return false;
        }
        return true;
    }

}
