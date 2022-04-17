package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallController {
    /**
     * 야구 게임 도메인 로직
     */
    public void playBaseball() throws IllegalArgumentException {
        BaseBallRepository baseball = new BaseBallRepository();
        do {
            baseball.countBaseball(getInput());
            baseball.printCountStatus();

            if(baseball.getStrikeCount() == 3){
                baseball.postProcessOfBaseball(getContinueInput());
            }
        } while(baseball.getStrikeCount() != 3);
    }

    /**
     * UI - 숫자 입력받기
     */
    private String getInput() throws IllegalArgumentException {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();

        if(!isValidNum(input))
            throw new IllegalArgumentException();

        return input;
    }

    /**
     * UI - 계속 여부 입력 받기
     */
    private String getContinueInput() throws IllegalArgumentException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = Console.readLine();

        if(!isValidContinueInput(input))
            throw new IllegalArgumentException();

        return input;
    }

    /**
     * 입력된 숫자 유효성 검사
     */
    private boolean isValidNum(String s){
        return s.length() == 3 && s.chars().allMatch(Character::isDigit);
    }

    /**
     * 계속 여부 입력 유효성 검사
     */
    private boolean isValidContinueInput(String c) {
        return c.length() == 1 && "12".contains(c) && c.chars().allMatch(Character::isDigit) ;
    }
}
