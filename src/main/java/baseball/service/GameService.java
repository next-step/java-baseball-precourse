package baseball.service;

import baseball.domain.PickNumberMatchResultView;

public interface GameService {

    PickNumberMatchResultView compareBallNumber(String readPickNumber);
}
