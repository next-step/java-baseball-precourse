package baseball.controller;

import baseball.domain.BaseBallNumbers;
import baseball.domain.BaseBallNumbersGenerator;
import baseball.domain.BaseBallUmpire;
import baseball.domain.BaseBallUmpireProcessor;
import baseball.enums.RetryStatus;
import baseball.view.BaseBallConsole;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallController {

    private final BaseBallNumbersGenerator baseBallNumberGenerator;
    private final BaseBallConsole baseBallConsole;
    private final BaseBallUmpireProcessor baseBallUmpireProcessor;

    public BaseBallController(BaseBallNumbersGenerator baseBallNumberGenerator, BaseBallConsole baseBallConsole,
                              BaseBallUmpireProcessor baseBallUmpireProcessor) {
        this.baseBallNumberGenerator = baseBallNumberGenerator;
        this.baseBallConsole = baseBallConsole;
        this.baseBallUmpireProcessor = baseBallUmpireProcessor;
    }

    public void start() {
        BaseBallNumbers computer = baseBallNumberGenerator.createRandomBaseBallNumbers();
        BaseBallUmpire baseBallUmpire = new BaseBallUmpire(0, 0);
        while (!baseBallUmpire.isStrikeOut()) {
            baseBallConsole.startBaseball();
            BaseBallNumbers user = baseBallNumberGenerator.createBaseBallNumbers(Console.readLine());
            baseBallUmpire = baseBallUmpireProcessor.process(computer, user);
            baseBallConsole.printUmpireResult(baseBallUmpire);
        }
        retryBaseBallGameOrNot();
    }

    private void retryBaseBallGameOrNot() {
        baseBallConsole.printRetry();
        if (RetryStatus.RETRY.equals(getRetryStatus()))
            start();
    }

    private RetryStatus getRetryStatus() {
        return RetryStatus.fromCode(Console.readLine());
    }
}
