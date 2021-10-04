package baseball.service;

import baseball.domain.PickNumberMatchResultView;

public interface GameService {

    PickNumberMatchResultView comparePickNumber(String readPickNumber);

    boolean isValidReadPickNumber(String readPickNumber);
}
