package baseball;

import baseball.application.BaseballService;
import baseball.application.ResumeOrNot;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        do {
            BaseballService baseballService = new BaseballService();
            baseballService.playBaseball();
        } while (isResumeOpinion());
    }

    public static boolean isResumeOpinion() {
        try {
            ResumeOrNot opinion = new ResumeOrNot(readLine());
            return opinion.isResume();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return isResumeOpinion();
        }
    }
}
