package baseball.controller;

import baseball.controller.validation.Validator;
import baseball.domain.service.BaseballService;
import baseball.view.BaseballView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballController {

    private final BaseballService service;
    private final BaseballView baseballView;
    private final List<Validator> validators;

    public BaseballController(BaseballService service, BaseballView baseballView,
                              List<Validator> validators) {
        this.service = service;
        this.baseballView = baseballView;
        this.validators = validators;
    }

    public void createBaseball() {
        String randomValue = createRandomValue();
        service.saveBaseball(randomValue);
    }

    public void playBaseball() {
        String input = baseballView.readLine();
        for (Validator validator : validators) {
            validator.check(input);
        }
        service.playBaseball(input);
    }

    public void result() {
        baseballView.printResult(service.resultBaseball());
    }

    private String createRandomValue() {
        Set<Integer> randomSet = new HashSet<>();
        while (randomSet.size() != 3) {
            randomSet.add(Randoms.pickNumberInRange(1, 9));
        }
        StringBuilder randomValue = new StringBuilder();
        for (Integer random : randomSet) {
            randomValue.append(random);
        }
        return randomValue.toString();
    }

    public boolean isComplete() {
        boolean complete = service.isComplete();
        if (complete) {
            baseballView.printCompleteMessage();
            complete = baseballView.completeReadLine();
            checkRetry(complete);
        }
        return complete;
    }

    private void checkRetry(boolean complete) {
        if (!complete) {
            createBaseball();
        }
    }
}
