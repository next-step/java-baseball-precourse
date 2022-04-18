package Utils;

import camp.nextstep.edu.missionutils.Console;
import config.InputPolicy;
import config.Policy;

public class UserInput {
    public static String inGame(){
        while(true){
            System.out.print("숫자를 입력해주세요 : ");

            String userInput = Console.readLine();
            if(InputPolicy.defaultPolicy(userInput, Policy.IN_GAME_NUMBER_LENGTH)){
                return userInput;
            }

            System.out.println(Policy.IN_GAME_NUMBER_LENGTH + "자리 정수만 입력해주세요.");
        }
    }

    public static String inMenu(){
        while (true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String userInput = Console.readLine();
            if(InputPolicy.defaultPolicy(userInput, Policy.IN_MENU_USER_INPUT_LENGTH) && InputPolicy.addPolicyInMenu(userInput)) {
                return userInput;
            }
        }
    }
}
