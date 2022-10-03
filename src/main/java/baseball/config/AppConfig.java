package baseball.config;

import baseball.controller.BaseballController;
import baseball.controller.validation.DifferentNumberValidator;
import baseball.controller.validation.LengthValidator;
import baseball.controller.validation.RangeValidator;
import baseball.controller.validation.Validator;
import baseball.domain.repository.BaseballRepository;
import baseball.domain.repository.BaseballRepositoryImpl;
import baseball.domain.rule.BallRule;
import baseball.domain.rule.Rule;
import baseball.domain.rule.StrikeRule;
import baseball.domain.service.BaseballService;
import baseball.domain.service.BaseballServiceImpl;
import baseball.view.BaseballConsoleView;
import baseball.view.BaseballView;
import java.util.Arrays;
import java.util.List;

public class AppConfig {
    public static BaseballView getView() {
        return new BaseballConsoleView();
    }

    public static BaseballController getController() {
        return new BaseballController(getService(), getView(), getValidators());
    }

    public static BaseballService getService() {
        return new BaseballServiceImpl(getRepository(), getRules());
    }

    public static BaseballRepository getRepository() {
        return new BaseballRepositoryImpl();
    }

    public static List<Rule> getRules() {
        return Arrays.asList(new StrikeRule(), new BallRule());
    }

    public static List<Validator> getValidators() {
        return Arrays
                .asList(new LengthValidator(), new RangeValidator(), new DifferentNumberValidator());
    }
}
