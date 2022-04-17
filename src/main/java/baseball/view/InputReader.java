package baseball.view;

import java.util.List;

public interface InputReader {
    enum ReGameAnswer {
        ReGame,
        End
    }

    List<Integer> readBallNumber();
    ReGameAnswer readReGameFlag();
}
