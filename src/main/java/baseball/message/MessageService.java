package baseball.message;

public interface MessageService {
    void start();

    void finish(int num);

    void error();

    void result(int ball, int strike);
}
