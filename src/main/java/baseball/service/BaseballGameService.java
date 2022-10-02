package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.GameResult;
import baseball.dto.BaseballGameResultDto;

public class BaseballGameService {

    /**
     * 게임 1턴 진행
     *
     * @param computer 컴퓨터의 수
     * @param player 플레이어의 수
     * @return 게임 결과
     */
    public BaseballGameResultDto playGame(BaseballNumber computer, BaseballNumber player) {
        return new BaseballGameResultDto(new GameResult(computer, player));
    }
}
