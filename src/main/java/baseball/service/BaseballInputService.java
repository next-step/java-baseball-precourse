package baseball.service;

import baseball.domain.BaseballVO;

public interface BaseballInputService {

    String inputMessage(BaseballVO baseballVO);

    boolean validationAnswer(BaseballVO baseballVO);

    void continueGame(BaseballVO baseballVO);

}
