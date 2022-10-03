package baseball.domain.repository;

import baseball.domain.Baseball;

public interface BaseballRepository {

    void save(Baseball baseball);

    Baseball find();
}
