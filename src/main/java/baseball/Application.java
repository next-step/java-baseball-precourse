package baseball;

import custom.utils.Message;
import custom.utils.NumberValidation;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {
    public static void main(String[] args) {
        String comNumbers = ""+Randoms.pickNumberInRange(1,9)+Randoms.pickNumberInRange(1,9)+Randoms.pickNumberInRange(1,9);
        System.out.println("Com's Numbers : " + comNumbers);

        boolean isNumOkay = true;
        while(isNumOkay){
            Message.printInform("숫자를 입력해주세요 : ");
            String userNumbers = Console.readLine();

            if(NumberValidation.is3digitsOfLength(userNumbers)){
                continue;
            }
            if(NumberValidation.containOnlyNumber(userNumbers)){

            }
        }



    }

}
