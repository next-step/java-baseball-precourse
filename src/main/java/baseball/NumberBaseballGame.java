package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class NumberBaseballGame {

    private boolean play;
    private final int maxNumberLength;
    private Player computer;

    public NumberBaseballGame(int maxNumberLength){
        this.maxNumberLength = maxNumberLength;
        this.play = true;
        setUpPlayer();
    }

    private void setUpPlayer(){
        this.computer = new Player(this.randomNumbers());
    }

    private String randomNumbers(){
        String numbers = new String();
        while (numbers.length() < maxNumberLength){
            int randomNum = Randoms.pickNumberInRange(1, 9);

            if(numbers.indexOf(randomNum) < 0){
                numbers += randomNum;
            }
        }
        return numbers;
    }

    public boolean isPlay() { return this.play; }

    public boolean playing(String number) {
        this.validateNumber(number);
        ResultState resultState = this.countBollAndStrike(computer.getNumber(), number);
        String message = this.printResultMessage(resultState);
        System.out.println(message);
        return resultState.getStrike() != maxNumberLength;
    }

    public void validateNumber(String number) throws IllegalArgumentException{
        if(number == null || number.length() != maxNumberLength)
            throw new IllegalArgumentException();

        Set<Character> duplicateNumber = new HashSet<>();
        for (char num : number.toCharArray()) duplicateNumber.add(num);
        if(duplicateNumber.size() != number.length())
            throw new IllegalArgumentException();
    }

    public ResultState countBollAndStrike(String defenseNum, String attackNum){
        ResultState result = new ResultState();
        for(int i = 0; i < maxNumberLength; i++){
            if(defenseNum.charAt(i) == attackNum.charAt(i)) {
                result.setStrike(result.getStrike() + 1);
                continue;
            }
            if(defenseNum.indexOf(attackNum.charAt(i)) > -1) result.setBoll(result.getBoll() + 1);
        }
        return result;
    }

    private String printResultMessage(ResultState resultCount){
        if(resultCount.isNothing()) return "낫싱";
        //if(resultCount.getStrike() == maxNumberLength) return maxNumberLength + "개의 숫자를 모두 맞히셨습니다.";
        StringBuilder msg = new StringBuilder();
        if(resultCount.getBoll() > 0) msg.append(resultCount.getBoll()).append("볼 ");
        if(resultCount.getStrike() > 0) msg.append(resultCount.getStrike()).append("스트라이크 ");
        return msg.toString();
    }

    public void restart(){
        //System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String readLine = Console.readLine();
        if(readLine.equals("2")){
            this.gameOver();
        }
        this.setUpPlayer();
    }

    public void gameOver(){
        this.play = false;
        System.out.println("게임 종료");
    }
}
