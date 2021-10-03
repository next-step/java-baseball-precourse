package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.LinkedHashSet;

public class Application {

    public static String setGame() {    // 처음 게임에 쓰일 3자리 난수 생성 (1~9번)

        LinkedHashSet<String> set = new LinkedHashSet<String>();
        while (set.size()<3) {
            set.add("" + Randoms.pickNumberInRange(1,9));
        }

        String returnNum="";
        for (String num : set) {
            returnNum+= num;
        }
        return returnNum;
    }

    public static boolean checkNumber(String str_num) {    // 유저가 입력한 숫자가 이상이 없는지 확인
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

    public static String reStartORnot() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 끝내려면 2를 입력해주세요.");
        return Console.readLine();
    }

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현

        String userNumber = "";   // 유저의 숫자를 담을 공간
        String answerNumber ="";  // 정답의 숫자를 담을 공간

        int strike = 0;
        int ball = 0;
        boolean reGameCheck=true;    // 정답 숫자를 재설정 할건지 결정

        while(true)
        {
            if(reGameCheck==true) {
                answerNumber = setGame();
                reGameCheck=false;
            }

            strike = 0;   // 한턴 돌때마다 초기화
            ball = 0;

            //System.out.println(answerNumber); // 미리 정답을 출력해 보고 싶을때(test용)

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

            if (strike!=3) {  // Hint 출력
                System.out.println(strike+"스트라이크 " + ball+" 볼");
                continue;
            }

            if (reStartORnot().equals("2"))  // 3 strike, 게임 종료
                break;

            reGameCheck = true;  // 3 strike, 게임 재실행
        }
    }
}
