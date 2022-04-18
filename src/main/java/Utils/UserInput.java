package Utils;

import camp.nextstep.edu.missionutils.Console;
import config.Policy;

public class UserInput {
    public static String[] inGame(){
        while(true){
            System.out.print("숫자를 입력해주세요 : ");

            String userInput = Console.readLine();
            if(defaultPolicyUserInput(userInput, Policy.IN_GAME_NUMBER_LENGTH)){
                return userInput.split("");
            }

            System.out.println(Policy.IN_GAME_NUMBER_LENGTH + "자리 정수만 입력해주세요.");
        }
    }

    public static String inMenu(){
        while (true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String userInput = Console.readLine();
            if(defaultPolicyUserInput(userInput, Policy.IN_MENU_USER_INPUT_LENGTH) && addPolicyInMenu(userInput)) {
                return userInput;
            }
        }
    }

    private static boolean defaultPolicyUserInput(String userInput, int policyInputLength){
        try{
            if(userInput.length() != policyInputLength){
                return false;
            }

            Integer.valueOf(userInput);

            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }

    private static boolean addPolicyInMenu(String userInput){
        return userInput.equals("1") || userInput.equals("2");
    }
}
