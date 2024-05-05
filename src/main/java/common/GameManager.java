package common;

import java.util.*;
import vo.BaseBallAnsVO;
import vo.BaseBallVO;

public class GameManager{

    private BaseBallAnsVO ans;
    private BaseBallVO vo;
    private BaseBallMaker bm;

    private Scanner sc;

    private boolean endGame = false;

    public GameManager(){
        ans = new BaseBallAnsVO(false,0,0);
        vo = new BaseBallVO(0,0,0);
        bm = new BaseBallMaker();
        sc = new Scanner(System.in);
    }

    public boolean isEnd(){
        return endGame;
    }

    public void run() throws IllegalArgumentException{

        userInput();

        System.out.println(ans.toString());

        if(ans.isEnd()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            userEndorRestart();
        }

    }

    private void userInput() throws IllegalArgumentException{
        String userString;

        System.out.println("숫자를 입력해 주세요 : ");
        userString = sc.next();

        checkUserInput(userString);
        int[] toInts = changeUserInput(userString);

        vo.reset(toInts[0],toInts[1],toInts[2]);

        ans = bm.playBall(vo);
    }

    private void userEndorRestart() throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String snum = sc.next();
        int num = convertInt(snum);
        if(num == 1){
            bm.make();
            return;
        }
        if(num == 2){
            endGame = true;
            sc.close();
            return;
        }
        throw new IllegalArgumentException("end error");
    }

    private void checkUserInput(String s) throws IllegalArgumentException{
        if(s.isEmpty()){
            throw new IllegalArgumentException("empty except");
        }
        convertInt(s); // 잘못된 값인 경우
    }

    private int[] changeUserInput(String s){
        int[] ans = new int[3];
        int num = convertInt(s);

        ans[0] = num/100;
        ans[1] = (num%100)/10;
        ans[2] = num%10;

        return ans;
    }

    private int convertInt(String s) throws IllegalArgumentException{
       try{
           return Integer.parseInt(s);
       } catch (Exception e){
           throw new IllegalArgumentException("parse Int except");
       }
    }

}
