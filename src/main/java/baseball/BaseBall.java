package baseball;

import custom.utils.Message;
import custom.utils.NumberValidation;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

/**
 * @author Yun JiHun<venaCode93@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class BaseBall {

    /**
     * 야구게임 java api
     *
     * 사용자에게서 1~9의 서로다른 세자리의 숫자를 받아서,
     * 상대편(=컴퓨터)의 숫자와 같은지 확인하는 게임.
     *
     */
    private String comNumbers;
    private String userNumbers;

    public BaseBall(){

    }

    public void gameStart(){
        // 컴퓨터(상대자) 랜덤숫자
        this.comNumbers = getComNumbers();
        
        // 사용자 숫자 맞추는 구간
        while(true){
            if(matchTheNumber() == 3){break;}
        }
        
        //사용자에게 계속할지 안할지 묻기
        if(continueOrNot().equals("1")){
            gameStart();
        }
    }

    private int matchTheNumber(){
        // 사용자 입력값 받기
        this.userNumbers = getUserNumbers();

        // 스트라이크, 볼 계산
        int strikeNum = countStrike(comNumbers,userNumbers);
        int ballNum = countBall(comNumbers,userNumbers);

        // 사용자에게 힌트 출력
        printHint(strikeNum, ballNum);

        return strikeNum;
    }

    private String getComNumbers(){
        String comNumbers = "";
        boolean[] drawnNums  = new boolean[9];
        for(int i =0; i<3; i++){
            int drawnNum = drawNonDuplicateRandomNumber(drawnNums);
            comNumbers+=drawnNum;
            drawnNums[drawnNum-1] = true;
        }
        return comNumbers;
    }

    private int drawNonDuplicateRandomNumber(boolean[] drawnNums){
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

    private String getUserNumbers(){
        while(true){
            Message.printInform("숫자를 입력해주세요 : ");
            String userNumbers = Console.readLine();

            if(!NumberValidation.isdigitsOfLength(userNumbers, 3) || !NumberValidation.containOnlyNumber(userNumbers) || !NumberValidation.haveNoDuplicateNumbers(userNumbers)){
                continue;
            }
            return userNumbers;
        }
    }

    //
    private int countStrike(String comNumbers, String userNumbers){
        int strikeNum = 0;
        for(int i=0; i<comNumbers.length(); i++) {
            if(comNumbers.charAt(i) == userNumbers.charAt(i)){
                strikeNum++;
            }
        }
        return strikeNum;
    }

    private int countBall(String comNumbers, String userNumbers){
        int ballNum = 0;
        int[] countNumSet = getCountNumSet(comNumbers, userNumbers);
        for(int i=0; i<countNumSet.length; i++) {
            if(countNumSet[i] > 1){
                ballNum++;
            }
        }
        return ballNum;
    }

    private int[] getCountNumSet(String comNumbers, String userNumbers){
        int[] numSet = new int[9];
        for(int i=0; i<comNumbers.length(); i++) {
            if(comNumbers.charAt(i) != userNumbers.charAt(i)) {
                numSet[comNumbers.charAt(i) - '0' -1]++;
                numSet[userNumbers.charAt(i) - '0' -1]++;
            }
        }
        return numSet;
    }

    private void printHint(int strikeNum, int ballNum){
        String hint = "";
        if(strikeNum == 0 && ballNum == 0){ hint = "낫싱";}
        if(strikeNum > 0) { hint += strikeNum + "스트라이크 ";}
        if(ballNum > 0) { hint += ballNum + "볼";}
        Message.printlnInform(hint);
    }

    private String continueOrNot(){
        Message.printlnInform("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        while(true) {
            Message.printlnInform("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userAnswer = Console.readLine();
            if ("1".equals(userAnswer) || "2".equals(userAnswer)) {return userAnswer;}
            Message.printError("1 또는 2를 입력해주세요.");
        }
    }
}
