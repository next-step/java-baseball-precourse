package baseball.domain.repository;

import baseball.domain.Baseball;

public class BaseballRepositoryImpl implements BaseballRepository {

    private Baseball baseball;

    @Override
    public void save(Baseball baseball) {
        this.baseball = baseball;
    }

    @Override
    public Baseball find() {
        return baseball;
    }
}
