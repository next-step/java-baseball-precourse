package baseball.score;

import java.util.List;

public interface Score {
    void create(String str1, String str2);
    List<String> getScores();
}
