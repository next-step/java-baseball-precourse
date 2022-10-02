package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String computerPickNumString = Randoms.pickNumberInRange(0,999)+ "";

        while(true){
            System.out.print("숫자를 입력해주세요: ");
            String inputNumString = Console.readLine();
        }

    }

}
