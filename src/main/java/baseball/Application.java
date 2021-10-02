package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {

    public static String setGame() {    //맞춰야할 숫자 초기화
        String answerNum = "" + Randoms.pickNumberInRange(1,9) ;  // 정답 번호 : 1~9까지 랜덤수 하나를 투입
        while(answerNum.length()<3)
        {
            String strTemp = "" + Randoms.pickNumberInRange(1,9);
            if(answerNum.contains(strTemp) == false)   // 새로 받은 숫자가 기존에 존재 하지 않으면 투입!
                answerNum += strTemp;
        }
        return answerNum;
    }

    public static boolean checkNumber(String str_num) {    //유저가 입력한 숫자가 이상이 없는지 확인
        String strDoubleCheck="";

        if (str_num.length() != 3) {
            System.out.print("[ERROR] 숫자가 3자리가 아닙니다.");
            return false;
        }
        for(char x : str_num.toCharArray())
        {
            if ((int)x>(int)'9' || (int)x<(int)'1') {
                System.out.print("[ERROR] 1~9가 아닌 값이 있습니다.");
                return false;
            }
            if (strDoubleCheck.contains(""+x)==true){
                System.out.print("[ERROR] 중복된 값이 있습니다.");
                return false;
            }
            strDoubleCheck +=x;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현

        String userNumber = "";   // 유저의 숫자를 담을 공간
        String answerNumber ="";  // 정답의 숫자를 담을 공간

        int strike = 0;
        int ball = 0;
        boolean bReGame=true;    // 정답 숫자를 재설정 할건지 결정

        while(true)
        {
            if(bReGame==true) {
                answerNumber = setGame();
                bReGame=false;
            }

            strike = 0;   // 한턴 돌때마다 초기화
            ball = 0;

            System.out.println(answerNumber); // 미리 정답을 출력해 보고 싶을때(test용)

            System.out.print("숫자를 입력해 주세요 : ");
            userNumber =Console.readLine();

            while(!checkNumber(userNumber)) // 유저가 입력한 숫자가 문제가 없는지 확인
            {
                System.out.print(" 숫자를 다시 입력해 주세요 : ");
                userNumber =Console.readLine();
            }

            for (int i=0; i<3; i++) // 유저번호 vs 정답번호 비교
            {
                int temp= answerNumber.indexOf(userNumber.charAt(i));
                if (i==temp) strike++;
                if (i!=temp && temp!=-1) ball++;
            }

            if (strike==3)  //게임 끝
            {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
                System.out.println("게임을 새로 시작하려면 1, 끝내려면 2를 입력해주세요.");
                String isClose =Console.readLine();

                if(isClose.charAt(0) =='2')
                    break;
                if(isClose.charAt(0) =='1') {
                    bReGame = true;
                    continue;
                }
            }

            System.out.println(strike+"스트라이크 " + ball+" 볼");

        }
    }
}
