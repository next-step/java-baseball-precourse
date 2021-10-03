package baseball.view;

import baseball.domain.BaseballNumber;
import baseball.domain.CompareResult;
import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompareResultShowViewTest extends NSTest {

    private final CompareResultShowView compareResultShowView = new CompareResultShowView();
    private final CompareResult mock = mock(CompareResult.class);

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 낫싱_결과_출력_확인() {
        when(mock.isNothing()).thenReturn(true);
        compareResultShowView.show(mock);
        verify("낫싱");
    }

    @Test
    void 스트라이크_볼_같이_있는경우_결과_출력_확인() {
        when(mock.getStrike()).thenReturn(1);
        when(mock.getBall()).thenReturn(2);
        compareResultShowView.show(mock);
        verify("1스트라이크", "2볼");
    }

    @Test
    void 스트라이크가_정답개수와_일치한_경우_결과_출력_확인() {
        when(mock.getStrike()).thenReturn(BaseballNumber.BASEBALL_SIZE);
        when(mock.isSuccess()).thenReturn(true);
        compareResultShowView.show(mock);
        verify("스트라이크", "모두", "게임 끝");
    }

    @Override
    public void runMain() {}
}