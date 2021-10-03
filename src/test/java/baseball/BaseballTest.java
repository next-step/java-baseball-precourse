package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import baseball.game.Computer;
import nextstep.test.NSTest;
import nextstep.utils.Randoms;


public class BaseballTest extends NSTest {
	
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @ParameterizedTest
    @CsvSource(value = {"135,1,3,5", "475,4,7,5", "952,9,5,2"} , delimiter = ',')
    void 스트라이크확인(String input,int num1, int num2, int num3) {
    	
    	try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(num1, num2, num3)
                    ;
        	Computer computer = new Computer();
            int count = computer.getStrikeCount(input);
            assertEquals(count, 3);
            
        }
    }
    
    @ParameterizedTest
    @CsvSource(value = {"135,7,5,3,2", "475,5,3,1,1", "952,5,9,3,2"} , delimiter = ',')
    void 볼확인(String input,int num1, int num2, int num3, int result) {
    	
    	try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(num1, num2, num3)
                    ;
        	Computer computer = new Computer();
            int count = computer.getBallCount(input);
            assertEquals(count, result);
            
        }
    }
    
    @Test
    void 입력값오류확인() {
    	try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            run(
        			"asd", // 문자열 확인 
        			"111", // 같은 수 확인
        			"1a1", // 문자열 수자 확인
        			"1234", // 자리수 확인
        			"135" // 완료
        	) ;
        	verify(
        			"[ERROR] 숫자가 아닙니다.",
        			"[ERROR] 같은수가 존재합니다.",
        			"[ERROR] 숫자가 아닙니다.", 
        			"[ERROR] 입력값이 잘못되었습니다.", 
        			"3스트라이크",
        			"게임 끝"
        			);
        }
    }
    
    @Test
    void 정상진행확인() {
    	try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(6, 7, 1);
            run(
        			"123","345","617","671"
        	) ;
        	verify(
        			"1볼",
        			"낫싱",
        			"1스트라이크 2볼",
        			"3스트라이크",
        			"게임 끝"
        			);
        }
    }
    
    @AfterEach
    void tearDown() {
        outputStandard();
    }
    
	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}
