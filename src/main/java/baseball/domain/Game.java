package baseball.domain;

import java.util.List;


public class Game {
    private Computer computer = Computer.createComputer();
    private Player player;
    private int strike = 0;
    private int ball = 0;
    private int nothing =0;

    private Game(Player player){
        this.player = player;
    }


    private void countUpEachStatus(String playerInputNumber, List<String> computerNumbers){
        this.ball = 0;
        this.strike = 0;
        this.nothing = 0;
        String[] splitedPlayerInputNumber = playerInputNumber.split("");
        compareNumbers(playerInputNumber, computerNumbers);
    }


    private void compareNumbers(String playerNumber, List<String> computerNumbers){
        String[] splitedPlayerNumbers = playerNumber.split("");
        int computerNumberLength = computerNumbers.size();
        for(int idx=0; idx<splitedPlayerNumbers.length; idx++){
            int status = getStatusBySearchComputerNumbers(splitedPlayerNumbers[idx], computerNumbers, idx);
            uploadCountByCompareStatus(status);
        }
    }


    private int getStatusBySearchComputerNumbers(String number, List<String> computerNumbers, int currentIndex){
        if(isNothing(number, computerNumbers)) return 0;
        if(isStrike(number, computerNumbers.get(currentIndex))) return 1;
        if(isBall(number, computerNumbers.get(currentIndex))) return 2;
        return -1;
    }


    private boolean isNothing(String number, List<String>computerNumbers){
        if(computerNumbers.contains(number)){
            return false;
        }
        return true;
    }


    private boolean isStrike(String number, String computerNumbers){
        if(computerNumbers == number){
            return true;
        }
        return false;
    }


    private boolean isBall(String number, String computerNumbers){
        if(computerNumbers == number){
            return true;
        }
        return false;
    }


    private void uploadCountByCompareStatus(int compareStatus){
        if(compareStatus == 0){
            this.nothing += 1;
        }
        if(compareStatus == 1){
            this.strike += 1;
        }
        if(compareStatus == 2){
            this.ball += 1;
        }
    }
}
