package baseball.domain.repository;


import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Baseball;
import baseball.domain.result.DefaultResult;
import baseball.domain.result.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballRepositoryImplTest {

    BaseballRepository repository = new BaseballRepositoryImpl();

    @Test
    @DisplayName("baseball 객체를 메모리에 저장하고 찾는다")
    void save_find() {
        Result result = new DefaultResult();
        Baseball saveBaseball = new Baseball(result, "123");
        repository.save(saveBaseball);
        Baseball findBaseball = repository.find();
        assertThat(saveBaseball).isEqualTo(findBaseball);
    }

}