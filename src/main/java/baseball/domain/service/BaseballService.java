package baseball.domain.service;

public interface BaseballService {

    void saveBaseball(String randomValue);

    void playBaseball(String input);

    String resultBaseball();

    boolean isComplete();
}
