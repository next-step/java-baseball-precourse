package baseball.configuration;

import baseball.controller.BaseballGameController;
import baseball.repository.AnswerNumberRepository;
import baseball.repository.MemoryAnswerNumberRepository;
import baseball.service.BaseballGameService;
import baseball.service.BaseballGameServiceImpl;
import baseball.view.BaseballGameView;
import baseball.view.ConsoleBaseballGameView;

public class AppConfig {

    public BaseballGameController baseballGameController() {
        return new BaseballGameController(baseballGameService(), baseballGameView());
    }

    public BaseballGameView baseballGameView() {
        return new ConsoleBaseballGameView();
    }

    public BaseballGameService baseballGameService() {
        return new BaseballGameServiceImpl(answerNumberRepository());
    }

    public AnswerNumberRepository answerNumberRepository() {
        return new MemoryAnswerNumberRepository();
    }
}
