/*
 * Common.java
 * java-baseball-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 01/10/2021.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */

package baseball.commons;

import nextstep.utils.Console;

public class Common {

    public static Common common = new Common();

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
     * @param input Console API를 이용한 입력 받은 문자열
     */
    public static void isValidString(String input) {
        isValidInputString(input, Constant.GAME_PITCHING_COUNT);
        isValidDuplicateChar(input);
    }

    /**
     * 사용자 입력 값 유효성 검사 1
     * 제한된 자릿수의 숫자로만 생성된 문자열 검사
     * @param input Console API를 이용한 입력 받은 문자열
     * @param limit 문자열 길이 제한
     * @throws IllegalArgumentException 입력받은 문자열 속 숫자가 아닌 다른 문자가 있는 경우, 제한된 길이를 초과한 경우 발생한다.
     */
    private static void isValidInputString(String input, Integer limit) {
        if (!input.matches(String.format(Constant.ONLY_NUMBER_VALIDATE_REGEX, limit))) {
            throw new IllegalArgumentException(String.format("입력값이 옳지 않습니다.(%d자리의 1~9 사이의 숫자만 가능)", limit));
        }
    }

    /**
     * 사용자 입력 값 유효성 검사 2
     * 중복 문자 존재 여부 검사
     * @param input Console API를 이용한 입력 받은 문자열
     * @throws IllegalArgumentException 입력받은 문자열 속 문자가 중복된 경우 발생한다.
     */
    private static void isValidDuplicateChar(String input) {
        String newInput = "";
        for (int i = 0; i < Constant.GAME_PITCHING_COUNT; i++) {
            if (newInput.indexOf(input.charAt(i)) != -1) {
                throw new IllegalArgumentException("입력값이 옳지 않습니다.(중복된 수를 입력할 수 없습니다.)");
            }
            newInput += input.charAt(i);
        }
    }
}
