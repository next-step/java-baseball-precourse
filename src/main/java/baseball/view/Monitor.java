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
        }

        Arrays.sort(answer);
    }

    private boolean validateResult(int[] answer) {
        return answer[0] != answer[1]
            && answer[0] != answer[2]
            && answer[1] != answer[2];
    }

    public void gameStart() {
        createAnswer();

        gameStart("1");
    }

    public void gameStart(String choice) {
        if (choice.startsWith("1")) {
            System.out.print(showGameMessage(choice));

            String tryStr = Console.readLine();

            char[] ch = tryStr.toCharArray();

            int strike_cnt = 0;

            for(int i = 0; i < 3; i++) {
                if(ch[i] - '0' == answer[i]) {
                    strike_cnt++;
                }
            }

            int ball_cnt = 0;

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(i != j && ch[i] == answer[j]) {
                        ball_cnt++;
                    }
                }
            }

            if(strike_cnt > 0) {
                System.out.print(strike_cnt + KorGamePlayMsg.STRIKE_MSG);
            }

            if(strike_cnt + ball_cnt > 0) {
                System.out.print(" ");
            }

            if(ball_cnt > 0) {
                System.out.print(ball_cnt + KorGamePlayMsg.BALL_MSG);
            }

            if(strike_cnt == 3) {
                gameStart();

                return;
            }

            return;
        }

        if (choice.startsWith("2")) {
            System.out.print(KorGamePlayMsg.GAME_STAY_MSG);
            return;
        }

        if (choice.startsWith(" ")) {
            System.out.print("Game Over!!");

            return;
        }

        createAnswer();

        gameStart(Console.readLine());
    }

    public String showGameMessage(String choice) {
        if (choice.startsWith("0")) {
            return KorGamePlayMsg.GAME_OVER_MSG;
        }

        if (choice.startsWith("1")) {
            return KorGamePlayMsg.PRESS_NUMBER_MSG;
        }

        return KorGamePlayMsg.GAME_STAY_MSG;
    }
}
