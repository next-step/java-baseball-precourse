package baseball;

import java.util.*;

import static nextstep.utils.Console.readLine;
import static nextstep.utils.Randoms.pickNumberInRange;

public class Baseball {
    private int strike = 0;
    private int ball = 0;
    boolean gameEndFlag = false;

    public void startGame() {
        strike = 0; ball = 0; gameEndFlag = false;
        List<Character> gameNumberList = generateNumber();
        System.out.println("정답 확인 : " + gameNumberList);
        while(!gameEndFlag){
            String result = checkNumber(gameNumberList, inputNumber() );
            System.out.println(result);
            endThisGame(result);
        }
        System.out.println("게임 끝");
    }

    //    컴퓨터는 1에서9까지 서로 다른 임의의 수 3개를 선택한다.
    public List<Character> generateNumber(){
        Set<Character> gameNumberSet = new LinkedHashSet<>();
        while(gameNumberSet.size() < 3) {
            gameNumberSet.add( Integer.toString(pickNumberInRange(1, 9)).charAt(0));
        }
        return new ArrayList<>(gameNumberSet);
    }

    //    기본적으로1부터9까지서로다른수로이루어진3자리의수를맞추는게임이다.
    public List<Character> inputNumber(){
        boolean validInputNumberFlag = false;
        List<Character> inputNumberList = new ArrayList<>();
        while(!validInputNumberFlag){
            System.out.println("숫자를 입력해주세요 : ");
            String inputNumberString  = readLine();

            inputNumberList = convertStringToList(inputNumberString);
            validInputNumberFlag = validInputNumber(inputNumberString, inputNumberList);
        }
        return inputNumberList;
    }

    public List<Character> convertStringToList(String inputNumberString){
        List<Character> inputNumberList = new ArrayList<>();
        for (char ch :inputNumberString.toCharArray()) {
            inputNumberList.add(ch);
        }
        return inputNumberList;
    }

    public boolean validInputNumber(String inputNumberString, List inputNumberSet){
        if (!inputNumberString.matches("[0-9]+") ) {
            System.out.println("[ERROR] 잘못된 값을 입력하셨습니다.");
            return false;
        }
        if (inputNumberSet.size() > 3){
            System.out.println("[ERROR] 잘못된 값을 입력하셨습니다.");
            return false;
        }
        return true;
    }


    //    같은수가같은자리에있으면스트라이크,다른자리에있으면볼,같은수가전혀없으면포볼또는낫싱
    public String checkNumber(List<Character> gameNumberList, List<Character> inputNumberList){
        strike=0;
        ball=0;
        for (int i = 0; i < gameNumberList.size(); i++) {
            ballCheck(gameNumberList.toString(), gameNumberList.get(i), inputNumberList.get(i));
        }
        return makeResultString(strike, ball);
    }

    public void ballCheck(String gameNumberString, char gameNumber,  char inputNumber){
        if (gameNumber == inputNumber){
            this.strike++;
            return;
        }
        if (gameNumberString.contains(String.valueOf(inputNumber)))  this.ball++;
    }

    public String makeResultString(int strike, int ball){
        String result = "";
        if(strike==0 && ball == 0) result = "낫싱";
        if(strike> 0) result = result  + strike + "스트라이크 ";
        if(ball> 0) result = result  + ball + "볼";
        return result.trim();
    }

    public void endThisGame(String result){
        if (result.equals("3스트라이크")) gameEndFlag = true;
    }

    //    게임을종료한후게임을다시시작하거나완전히종료할수있다.
    public boolean endGame(){
        boolean validInputNumberFlag = false;
        String endGameInput = "";
        while(!validInputNumberFlag) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 ");
            endGameInput = readLine();
            validInputNumberFlag = validInputEndFlag(endGameInput);
        }
        return endGameInput.equals("1") ? true : false;
    }

    public boolean validInputEndFlag(String endGameInput){
        if (!"12".contains(endGameInput)) {
            System.out.println("[ERROR] 잘못된 값을 입력하셨습니다.");
            return false;
        }
        return true;
    }
}
