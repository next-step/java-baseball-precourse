/*
 * Pitcher.java
 * java-baseball-precourse
 *
 * Version 0.2
 *
 * Created by 강래민 on 01/10/2021.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */

package baseball.utils;


import baseball.commons.Constant;
import nextstep.utils.Randoms;

public class Pitcher {

    private static final Pitcher PITCHER = new Pitcher();

    private Pitcher() {
    }

    /**
     * 상대방(컴퓨터) 난수 생성
     */
    public static String pitching() {
        String result = "";
        while (result.length() < Constant.GAME_PITCHING_COUNT) {
            Integer num = Randoms.pickNumberInRange(Constant.GAME_BALL_MIN, Constant.GAME_BALL_MAX);
            if (!result.contains(num.toString())) {
                result += num.toString();
            }
        }
        return result;
    }
}
