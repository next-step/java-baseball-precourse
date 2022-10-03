package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import baseball.domain.BaseballComputer;
import baseball.constants.NumMessage;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameView {
	
    public static List<Integer> readInputNumbers() throws IllegalArgumentException {
        System.out.print(NumMessage.GAME_START);
        String input = Console.readLine();
        if (!validateInput(input)) {
            throw new IllegalArgumentException();
        }
        return convertStringToIntegerList(input);
    }

    private static List<Integer> convertStringToIntegerList(String inputStr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            result.add(inputStr.charAt(i) - '0');
        }
        return result;
    }

    private static boolean validateInput(String str) {
        if(!isValidLength(str)){
        	return false;
        }
        if(!isValidNumber(str)){
            return false;
        }
        return true;
    }
    
    private static boolean isValidLength(String str) throws IllegalArgumentException{
        if(str.length() != 3){
        	throw new IllegalArgumentException(NumMessage.MESSAGE_VALIDATION_INPUT_LENGTH);
        }
        return true;
    }

    private static boolean isValidNumber(String str) throws IllegalArgumentException{
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        char c3 = str.charAt(2);

        if(c1 < '1' || c1 > '9' || c2 < '1' || c2 > '9' || c3 < '1' || c3 > '9'){
        	throw new IllegalArgumentException(NumMessage.MESSAGE_VALIDATION_INPUT_RANGE);
        }
        if(c1 == c2 || c2 == c3 || c1 == c3){
        	throw new IllegalArgumentException(NumMessage.MESSAGE_VALIDATION_INPUT_DUPLICATE);
        }

        return true;
    }
    
    public static void getResult(BaseballComputer baseballComputer) {
    	if(baseballComputer.getBallCount() > 0){
    		System.out.print(baseballComputer.getBallCount()+NumMessage.BALL+" ");
    	}
    	if(baseballComputer.getStrikeCount() > 0){
    		System.out.print(baseballComputer.getStrikeCount()+NumMessage.STRIKE);
    	}
    	if(baseballComputer.getBallCount() == 0 && baseballComputer.getStrikeCount() == 0){
    		System.out.print(NumMessage.NOTHING);
    	}
    	System.out.print("\n");
    }
    
    public static boolean checkGameStatus() {
    	System.out.println(NumMessage.GAME_RESTART);
    	String answer = Console.readLine();
    	if(answer.equals(NumMessage.INPUT_GAME_RESTART))
    		return true;
    	if(answer.equals(NumMessage.INPUT_GAME_END))
    		return false;
    	throw new IllegalArgumentException(NumMessage.MESSAGE_VALIDATION_INPUT_END);
    }
    
    public static void showGameEnd() {
    	System.out.println(NumMessage.GAME_END);
    }
}