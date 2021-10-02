/*
 * Common.java
 * java-baseball-precourse
 *
 * Version 0.2
 *
 * Created by 강래민 on 01/10/2021.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */

package baseball.commons;

import baseball.exception.IncorrectInputException;
import baseball.utils.Score;
import nextstep.utils.Console;

public class Common {

    public static Common common = new Common();
    private static Score score;

    private Common() {

    }

    /**
     * 사용자로부터 받는 입력
     */
    public static String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    /**
     * 사용자 입력 값 유효성 검사 모음
     *
     * @param input Console API를 이용하여 입력 받은 문자열
     * @param limit 문자열 길이 제한
     * @return 입력된 문자열의 정상 여부
     */
    public static Boolean isValidString(String input, Integer limit) {
        try {
            isValidInputString(input, limit);
            isValidDuplicateChar(input, limit);
        } catch (IncorrectInputException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 사용자 입력 값 유효성 검사 1
     * 제한된 자릿수의 숫자로만 생성된 문자열 검사
     *
     * @param input Console API를 이용하여 입력 받은 문자열
     * @param limit 문자열 길이 제한
     * @throws IncorrectInputException 입력받은 문자열 속 숫자가 아닌 다른 문자가 있는 경우, 제한된 길이를 초과한 경우 발생한다.
     */
    private static void isValidInputString(String input, Integer limit) {
        if (!input.matches(String.format(Constant.ONLY_NUMBER_VALIDATE_REGEX, limit))) {
            throw new IncorrectInputException(String.format("입력값이 옳지 않습니다.(%d자리의 1~9 사이의 숫자만 가능)", limit));
        }
    }

    /**
     * 사용자 입력 값 유효성 검사 2
     * 중복 문자 존재 여부 검사
     *
     * @param input Console API를 이용하여 입력 받은 문자열
     * @param limit 문자열 길이 제한
     * @throws IncorrectInputException 입력받은 문자열 속 문자가 중복된 경우 발생한다.
     */
    private static void isValidDuplicateChar(String input, Integer limit) {
        String newInput = "";
        for (int i = 0; i < limit; i++) {
            if (newInput.indexOf(input.charAt(i)) != -1) {
                throw new IncorrectInputException("입력값이 옳지 않습니다.(중복된 수를 입력할 수 없습니다.)");
            }
            newInput += input.charAt(i);
        }
    }

    /**
     * 스트라이크 종료 판단 로직
     *
     * @param pitcherNumber 생성된 상대방(컴퓨터) 난수
     * @param inputNumber   사용자 입력
     * @return 라운드 종료 조건 충족 여부
     */
    public static Boolean isThreeStrikeGameOver(String pitcherNumber, String inputNumber) {
        score.scoreCalculation(pitcherNumber, inputNumber);
        if (!score.isNothing()) {
            System.out.println(score.toString());
        }
        return score.isThreeStrike();
    }

    /**
     * 게임을 계속 진행 판단 로직
     *
     * @return 라운드 종료 후 게임 지속 진행 여부
     */
    public static Boolean isContinueGame() {
        String input = "";
        do {
            System.out.println("게임을 새로 시작하려면 " + Constant.GAME_CONTINUE + ", 종료하려면 " + Constant.GAME_OVER + "를 입력하세요.");
            input = Console.readLine();
        } while (!isValidString(input, Constant.GAME_RESTART_FLAG_LENGTH));
        return (input.equals(Constant.GAME_CONTINUE.toString()));
    }

    /**
     * 매 라운드 진행시 초기화 로직
     * 추후 게임 초기화 작업 추가시 해당 로직에 추가할 것.
     */
    public static void initGameSetting() {
        score = new Score(0, 0);
    }
}
