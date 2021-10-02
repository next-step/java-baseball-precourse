/*
 * Application.java
 * java-baseball-precourse
 *
 * Version 0.2
 *
 * Created by 강래민 on 01/10/2021.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */

package baseball;

import baseball.commons.Common;
import baseball.commons.Constant;
import baseball.utils.Pitcher;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        do {
            String pitching = Pitcher.pitching();
            System.out.println("Pitching : " + pitching);
            running(pitching);
        } while (Common.isContinueGame());
    }

    /**
     * 게임 실행부
     *
     * @param pitching 상대방(컴퓨터) 난수
     * 종료 조건 : 입력 문자열 유효성 검사 성공 && 3스트라이크의 경우
     */
    private static void running(String pitching) {
        String input = "";
        do {
            Common.initGameSetting();
            input = Common.inputNumbers();
        } while (!(Common.isValidString(input, Constant.GAME_PITCHING_COUNT) && Common.isThreeStrikeGameOver(pitching, input)));
    }
}
