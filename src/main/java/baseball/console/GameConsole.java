package baseball.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class GameConsole implements ConsoleInterface {
    
    @Override
    public String input() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputText = Console.readLine();
        
        if (!this.validInput(inputText)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        
        return inputText;
    }
    
    @Override
    public boolean isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputText = Console.readLine();
        
        return EndCode.isExit(inputText);
    }
    
    public boolean validInput(String inputText) {
        Pattern inputPattern = Pattern.compile("[1-9]{3}");
        return inputPattern.matcher(inputText).matches();
    }
}
