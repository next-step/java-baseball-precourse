package logic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ui.BaseballUi;

public class BaseballLogicTest {
	
	BaseballLogic bl;
	
	@BeforeEach
    void beforeEach() {
		bl = new BaseballLogic(new BaseballUi());
    }
	
	@Test
	@DisplayName("사용자 입력값의 길이 체크(3자리)")
	void isValidLength() {
		String[] correct = {"1", "2", "5"};		// 정상(3자리)
		String[] wrong = {"1", "2", "3", "4"};	// 비정상
		assertFalse(bl.isValidLength(wrong));
		assertTrue(bl.isValidLength(correct));
	}

	
	@Test
	@DisplayName("사용자 입력값의 문자 체크(숫자 1 ~ 9)")
    void isValidNumbers() {
		String[] correct = {"1", "2", "5"};	// 정상(1 ~ 9)
		String[] wrong = {"0", "1", "a"};	// 비정상
		assertFalse(bl.isValidNumbers(wrong));
		assertTrue(bl.isValidNumbers(correct));
    }
    
    
	@Test
	@DisplayName("사용자 입력값의 중복 체크(중복 불가)")
    void isNoDupNumbers() {
		String[] correct = {"1", "2", "5"};	// 정상(중복없음)
		String[] wrong = {"1", "1", "2"};	// 비정상(중복)
		assertFalse(bl.isNoDupNumbers(wrong));
		assertTrue(bl.isNoDupNumbers(correct));
    }
    
    
	@Test
	@DisplayName("생성된 문제의 유효성 체크(길이,문자,중복)")
    void genGoals() {
		bl.genGoals();
		assertTrue(bl.isValidLength(bl.getGoals()));
		assertTrue(bl.isValidNumbers(bl.getGoals()));
		assertTrue(bl.isNoDupNumbers(bl.getGoals()));
    }
	
	@Test
	@DisplayName("결과 체크(스트라이크/볼)")
    void makeResult() {		
		// 3스트라이크
		bl.setGoals(new String[] {"1", "6", "4"});
		bl.setInputs(new String[] {"1", "6", "4"});
		bl.makeResult();
		assertTrue(bl.getResults()[0] == 3);	// 스트라이크
		assertTrue(bl.getResults()[1] == 0);	// 볼
		
		// 1스트라이크 1볼
		bl.setGoals(new String[] {"1", "6", "4"});
		bl.setInputs(new String[] {"1", "4", "3"});
		bl.makeResult();
		assertTrue(bl.getResults()[0] == 1);	// 스트라이크
		assertTrue(bl.getResults()[1] == 1);	// 볼
		
		// 낫싱
		bl.setGoals(new String[] {"1", "6", "4"});
		bl.setInputs(new String[] {"5", "7", "8"});
		bl.makeResult();
		assertTrue(bl.getResults()[0] == 0);	// 스트라이크
		assertTrue(bl.getResults()[1] == 0);	// 볼
    }
	
}
