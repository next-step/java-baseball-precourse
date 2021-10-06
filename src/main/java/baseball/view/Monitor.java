package baseball.view;

import baseball.constant.KorErrorMsg;
import baseball.constant.KorGamePlayMsg;
import baseball.constant.OptionSetting;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.Arrays;

public class Monitor {
    private int[] answer;

    public void createAnswer() {
        answer = new int[3];

        for (int i = 0; i < 3; i++) {
            answer[i] = Randoms.pickNumberInRange(
                OptionSetting.MIN_NUM,
                OptionSetting.MAX_NUM
            );
        }

        if (!validateResult(answer)) {
            createAnswer();

            return;
        }

        Arrays.sort(answer);
    }

    private boolean validateResult(int[] answer) {
        return answer[0] != answer[1]
            && answer[0] != answer[2]
            && answer[1] != answer[2];
    }

    private boolean validateResult(char[] answer) {
        return answer[0] != answer[1]
                && answer[0] != answer[2]
                && answer[1] != answer[2];
    }

    private int getStrikeCount(char[] ch) {
        int strike_cnt = 0;

        for(int i = 0; i < 3; i++) {
            if(ch[i] - '0' == answer[i]) {
                strike_cnt++;
            }
        }

        return strike_cnt;
    }

    private int getBallCount(char[] ch) {
        int ball_cnt = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i != j && ch[i] == answer[j]) {
                    ball_cnt++;
                }
            }
        }

        return ball_cnt;
    }

    public void gameStart() {
        createAnswer();

        gameStart("1");
    }

    private void gameStart(String choice) {
        if (choice.equals("0")) {
            System.out.print(KorGamePlayMsg.GAME_STAY_MSG);

            gameStart(Console.readLine());

            return;
        }

        if (choice.equals("1")) {
            System.out.print(KorGamePlayMsg.PRESS_NUMBER_MSG);

            String tryStr = Console.readLine();

            if (tryStr == null || tryStr.length() != 3 || !validateResult(tryStr.toCharArray())) {
                System.out.println(KorErrorMsg.NUMBER_ERROR_MSG);

                gameStart("1");

                return;
            }

            for (int i = 0; i < 3; i++) {
                if (!Character.isDigit(tryStr.charAt(i))) {
                    System.out.println(KorErrorMsg.NUMBER_ERROR_MSG);

                    gameStart("1");

                    return;
                }
            }

            char[] ch = tryStr.toCharArray();

            int strike_cnt = getStrikeCount(ch);

            int ball_cnt = getBallCount(ch);

            if(strike_cnt > 0) {
                System.out.print(strike_cnt + KorGamePlayMsg.STRIKE_MSG);
            }

            if(ball_cnt > 0) {
                System.out.print(ball_cnt + KorGamePlayMsg.BALL_MSG);
            }

            if(strike_cnt + ball_cnt == 0) {
                System.out.print(KorGamePlayMsg.NOTHING_MSG);
            }

            System.out.println();

            if(strike_cnt == 3) {
                System.out.print(KorGamePlayMsg.GAME_OVER_MSG);

                tryStr = Console.readLine();

                if (tryStr.equals("1")) {
                    gameStart();

                    return;
                }

                gameStart(tryStr);

                return;
            }

            gameStart("1");

            return;
        }

        if (choice.equals("2")) {
            gameStart("0");

            return;
        }

        if (choice.equals(" ")) {
            System.out.println("Game Over!!");

            return;
        }

        gameStart();
    }
}
