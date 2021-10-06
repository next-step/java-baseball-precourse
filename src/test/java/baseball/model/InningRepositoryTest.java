package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InningRepositoryTest {
    InningRepository inningRepository;

    @BeforeEach
    @DisplayName("매번 테스트마다 적용")
    void 초기화(){
        inningRepository = new InningRepository();
    }

    @Test
    @DisplayName("모델 확인용도 테스트 케이스")
    void 모델테스트(){

        inningRepository.setAnswer("test");
        Assertions.assertEquals("test", inningRepository.getAnswer());

        inningRepository.setAnswer("test2");
        Assertions.assertEquals("test2", inningRepository.getAnswer());

        inningRepository.setStirikeCnt(3);
        Assertions.assertEquals(3, inningRepository.getStrikeCnt());

        inningRepository.setUserInput("test4");
        Assertions.assertEquals("test4", inningRepository.getUserInput());

        inningRepository.setBallCnt(5);
        Assertions.assertEquals(5, inningRepository.getBallCnt());
    }
}
