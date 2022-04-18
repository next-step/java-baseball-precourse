package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;


public class Game {
    private Computer computer = Computer.createComputer();
    private Player player;
    private int strike = 0;
    private int ball = 0;
    private int nothing =0;
    private final String INPUT_MESSAGE = "숫자를 입력해주세요 :";
    private final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String INPUT_ERROR_MESSAGE = "잘못 입력하셨습니다. 숫자 세개를 입력해주세요.";
    private String gameStatus = "playing";

    public Game(Player player){
        this.player = player;
    }


    public void createGame(){
        System.out.println(INPUT_MESSAGE); //숫자입력권유 메시지 출력
        ArrayList<String> computerNumberList = computer.generateRandomNumberList();
        while(gameStatus == "playing") {
            String playerInputNumber = player.enterNumber();
            isValidateInputValue(playerInputNumber);
            countUpEachStatus(playerInputNumber, computerNumberList);
            printCompareResult();
            checkEndGame();
        }
    }


    private void countUpEachStatus(String playerInputNumber, List<String> computerNumbers){
        this.ball = 0;
        this.strike = 0;
        this.nothing = 0;
        compareNumbers(playerInputNumber, computerNumbers);
    }
    

    private void compareNumbers(String playerNumber, List<String> computerNumbers){
        String[] splitedPlayerNumbers = playerNumber.split("");
        for (int idx=0; idx<splitedPlayerNumbers.length; idx++){
            int status = getStatusBySearchComputerNumbers(splitedPlayerNumbers[idx], computerNumbers, idx);
            uploadCountByCompareStatus(status);
        }
    }


    private int getStatusBySearchComputerNumbers(String number, List<String> computerNumbers, int currentIndex){
        if (isNothing(number, computerNumbers)) return 0;
        if (isStrike(number, computerNumbers.get(currentIndex))) return 1;
        if (isBall(number, computerNumbers.get(currentIndex))) return 2;
        return -1;
    }


    private boolean isNothing(String number, List<String>computerNumbers){
        if (!computerNumbers.contains(number)){
            return true;
        }
        return false;
    }


    private boolean isStrike(String number, String computerNumber){
        if (computerNumber.equals(number)){
            return true;
        }
        return false;
    }


    private boolean isBall(String number, String computerNumber){
        if (!computerNumber.equals(number)){
            return true;
        }
        return false;
    }


    private void uploadCountByCompareStatus(int compareStatus){
        if (compareStatus == 0){
            this.nothing += 1;
        }
        if (compareStatus == 1){
            this.strike += 1;
        }
        if (compareStatus == 2){
            this.ball += 1;
        }
    }


    private void printCompareResult(){
        if (this.nothing > 0 && this.strike == 0 && this.ball == 0) System.out.println("낫싱");
        if (this.strike == 0 && this.ball > 0) System.out.println(String.format("%d볼", this.ball));
        if (this.ball == 0 && this.strike > 0) System.out.println(String.format("%d스트라이크", this.strike));
        if (this.ball != 0 && this.strike != 0) System.out.println(String.format("%d볼 %d스트라이크", this.ball, this.strike));
    }


    private boolean isValidateInputValue(String playerInputNumber){
        if(isNumberLengthThree(playerInputNumber) && isAllNumbersIsDigit(playerInputNumber) && isAllNumbersBetweenOneToNine(playerInputNumber)){
            return true;
        }
        throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
    }


    private boolean isNumberLengthThree(String playerInputNumber) {
        if (playerInputNumber.length() == 3) {
            return true;
        }
        return false;
    }


    private boolean isAllNumbersIsDigit(String playerInputNumber){
        int digitCount = 0;
        for(int idx = 0; idx<playerInputNumber.length(); idx++){
            digitCount += isNumberDigit(playerInputNumber.charAt(idx));
        }
        if(digitCount == 3)return true;
        return false;
    }


    private int isNumberDigit(char number){
        if(Character.isDigit(number))return 1;
        return 0;
    }


    private boolean isAllNumbersBetweenOneToNine(String playerInputNumber){
        int betweenCount = 0;
        for(int idx = 0; idx<playerInputNumber.length(); idx++){
            betweenCount += isNumberBetweenOneToNine(playerInputNumber.charAt(idx));
        }
        if(betweenCount == 3)return true;
        return false;
    }


    private int isNumberBetweenOneToNine(char number){
        int numberToInt = Character.getNumericValue(number);
        if( numberToInt >= 1 && numberToInt <= 9)return 1;
        return 0;
    }


    private void checkEndGame(){
        if(this.strike == 3) {
            System.out.println(END_MESSAGE);
            askEndGame();
        }
    }


    private void askEndGame(){
        String inputValue = Console.readLine();
        if (inputValue.equals("1")){
            createGame();
        }
        if (inputValue.equals("2")){
            exitGame();
        }
    }


    private void exitGame(){
        this.gameStatus = "exit";
    }
}
