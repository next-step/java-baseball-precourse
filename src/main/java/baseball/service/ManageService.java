package baseball.service;


import baseball.model.Baseball;

public interface ManageService {
    void checkPlayerNum(String str);

    Baseball getAnswer(String userNumber, String givenNumber);

    void checkRestartGameNumber(String str);
}
