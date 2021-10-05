package baseball;

import custom.utils.Message;
import custom.utils.NumberValidation;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {
    public static void main(String[] args) {
        // 상대방(=컴퓨터) 랜덤 숫자 생성
        String comNumbers = getComNumbers();
        //Message.printInform("Com's Numbers : " + comNumbers);

        // 사용자 숫자 입력
        while(true){
            String userNumbers = getUserNumbers();

            // 스트라이크, 볼 계산
            int strikeNum = countStrike(comNumbers,userNumbers);
            int ballNum = countBall(comNumbers,userNumbers);

            // 힌트 출력
            printHint(strikeNum, ballNum);

            // 게임 재시작 또는 중단
            if(strikeNum == 3){
                comNumbers = continueOrNot();
            }
        }

    }

    // 1에서 9 사이의 중복없는 3자리 랜덤 숫자
    public static String getComNumbers(){
        String comNumbers = "";
        boolean[] drawnNums  = new boolean[9];
        for(int i =0; i<3; i++){
            int drawnNum = drawNonDuplicateRandomNumber(drawnNums);
            comNumbers+=drawnNum;
            drawnNums[drawnNum-1] = true;
        }
        return comNumbers;
    }

    public static int drawNonDuplicateRandomNumber(boolean[] drawnNums){
        int rand = 0;
        boolean isDrawn= true;
        while(isDrawn){
            rand = Randoms.pickNumberInRange(1,9);
            if(!drawnNums[rand -1]){
                isDrawn = false;
            }
        }
        return rand;
    }

    public static String getUserNumbers(){
        while(true){
            Message.printInform("숫자를 입력해주세요 : ");
            String userNumbers = Console.readLine();

            if(!NumberValidation.isdigitsOfLength(userNumbers, 3) || !NumberValidation.containOnlyNumber(userNumbers) || !NumberValidation.haveNoDuplicateNumbers(userNumbers)){
                continue;
            }
            return userNumbers;
        }
    }

    public static int countStrike(String comNumbers, String userNumbers){
        int strikeNum = 0;
        for(int i=0; i<comNumbers.length(); i++) {
            if(comNumbers.charAt(i) == userNumbers.charAt(i)){
                strikeNum++;
            }
        }
        return strikeNum;
    }

    public static int countBall(String comNumbers, String userNumbers){
        int ballNum = 0;
        int[] countNumSet = getCountNumSet(comNumbers, userNumbers);
        for(int i=0; i<countNumSet.length; i++) {
            if(countNumSet[i] > 1){
                ballNum++;
            }
        }
        return ballNum;
    }

    public static int[] getCountNumSet(String comNumbers, String userNumbers){
        int[] numSet = new int[9];
        for(int i=0; i<comNumbers.length(); i++) {
            if(comNumbers.charAt(i) != userNumbers.charAt(i)) {
                numSet[comNumbers.charAt(i) - '0' -1]++;
                numSet[userNumbers.charAt(i) - '0' -1]++;
            }
        }
        return numSet;
    }

    public static void printHint(int strikeNum, int ballNum){
        if(strikeNum == 0 && ballNum == 0){
            Message.printlnInform("낫싱");
        }
        if((strikeNum > 0 && strikeNum < 3) || ballNum > 0) {
            Message.printlnInform(strikeNum + "스트라이크 " + ballNum + "볼");
        }
    }

    public static String continueOrNot(){
        Message.printlnInform("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        while(true) {
            Message.printlnInform("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userAnswer = Console.readLine();
            if ("1".equals(userAnswer)) {return getComNumbers();}
            if ("2".equals(userAnswer)) {System.exit(0);}
            Message.printError("1 또는 2를 입력해주세요.");
        }
    }

}
