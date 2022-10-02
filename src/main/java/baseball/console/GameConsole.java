package baseball.console;

import baseball.score.ScoreBoard;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class GameConsole implements ConsoleInterface {
    
    @Override
    public ScoreBoard input() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputText = Console.readLine();
        
        if (!this.validInput(inputText)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        
        List<Integer> initScoreList = Arrays.asList(
                Integer.parseInt(String.valueOf(inputText.charAt(0))),
                Integer.parseInt(String.valueOf(inputText.charAt(1))),
                Integer.parseInt(String.valueOf(inputText.charAt(2)))
        );
        
        return new ScoreBoard(initScoreList);
    }
    
    @Override
    public boolean isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputText = Console.readLine();
        
        return EndCode.isExit(inputText);
    }
    
    @Override
    public void printCount(int strikeCount, int ballCount) {
        StringBuilder message = new StringBuilder();
        if (ballCount != 0) {
            message.append(ballCount)
                    .append("볼 ");
        }
        
        if (strikeCount != 0) {
            message.append(strikeCount)
                    .append("스트라이크");
        }
        
        System.out.println(message);
    }
    
    public boolean validInput(String inputText) {
        Pattern inputPattern = Pattern.compile("[1-9]{3}");
        return inputPattern.matcher(inputText).matches();
    }
}
