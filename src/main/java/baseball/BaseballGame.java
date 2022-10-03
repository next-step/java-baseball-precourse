package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.mockito.internal.creation.SuspendMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BaseballGame {

    private ArrayList<Integer> comNumber;
    private ArrayList<Integer> userNumber;
    private final int MAX_SIZE = 3;
    private final int START_NUM = 1;
    private final int END_NUM = 9;
    private int ball = 0;
    private int strike = 0;


    public BaseballGame(){
        baseballNumber();
    }

    public void baseballNumber(){
        comNumber = new ArrayList<>();
        for(int i = 0; i<3; i++){
            int num = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if(!comNumber.contains(num)){
                comNumber.add(num);
            }
        }
        for(int i = 0; i<comNumber.size(); i++){
            System.out.print(comNumber.get(i));

        }

    }

    public void userInputNumber(){
        System.out.println("숫자를 입력해 주세요");
        String intputNum = Console.readLine();
        this.userNumber = makeUserNumber(intputNum);
        checkUserInput();
        compareNumbers();
        System.out.println(compareResult());

    }
    public ArrayList<Integer> makeUserNumber(String inNum){
        String[] inArr = inNum.split("");
        ArrayList<Integer> uNum = new ArrayList<>();
        uNum = new ArrayList<>();
        for(int i = 0; i<inArr.length; i++){
            uNum.add(Integer.parseInt(inArr[i]));
        }
        return uNum;
    }

    public void checkUserInput(){
        if(userNumber.size() != MAX_SIZE){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
        }
        if(userNumber.contains(0)){
            throw new IllegalArgumentException("0을 제외한 숫자를 입력해주세요");
        }
        Set<Integer> tmpSet = new HashSet<>(userNumber);
        if(userNumber.size() != tmpSet.size()){
            throw new IllegalArgumentException("중복된 숫자가 있습니다. 다시 입력해주세요");
        }

    }

    public void compareNumbers(){
        this.ball = 0;
        this.strike = 0;
        for(int i = 0; i<userNumber.size(); i++){
            if(comNumber.indexOf(userNumber.get(i))==i){
                strike++;
                continue;
            }
            if(comNumber.contains(userNumber.get(i))){
                ball++;
            }

        }
    }

    public String compareResult(){
        System.out.println();
        if(ball != 0 && strike != 0){
            return (ball + "볼 "+strike+"스트라이크");
        }
        if(ball != 0 && strike == 0){
            return (ball + "볼");
        }
        if(ball == 0 && strike != 0){
            return (strike + "스트라이크");
        }

        return "낫싱";
    }

    public boolean endCheck(){
        if(strike == 3){
           System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임 종료");
           System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
           String input = Console.readLine();
           if(input.equals("1")){
               baseballNumber();
               return true;
           }
           if(input.equals("2")){
               return false;
           }
           throw new IllegalArgumentException("1또는 2를 입력해주세요.");
        }

        return true;

    }



}
