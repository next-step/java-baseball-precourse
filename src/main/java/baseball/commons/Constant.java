/*
 * Constant.java
 * java-baseball-precourse
 *
 * Version 0.3
 *
 * Created by 강래민 on 01/10/2021.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */

package baseball.commons;

public final class Constant {

    private Constant() {
    }

    public static Integer GAME_PITCHING_COUNT = 3;
    public static Integer GAME_BALL_MIN = 1;
    public static Integer GAME_BALL_MAX = 9;
    public static String ONLY_NUMBER_VALIDATE_REGEX = "^[1-%d]{%d}$";
    public static Integer GAME_RESTART_FLAG_LENGTH = 1;
    public static Integer GAME_RESTART_FLAG_MAX = 2;
    public static Integer GAME_CONTINUE = 1;
    public static Integer GAME_OVER = 2;

}
