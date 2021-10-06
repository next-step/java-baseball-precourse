package baseball.util;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.vo.BallNumberVo;

public class BallNumberUtilTest {
	@DisplayName("createSelectedNumberList 정상 동작 확인")
	@Test
	void createSelectedNumberList() {
		assertThat(BallNumberUtil.createSelectedNumberList()).isNotNull();
	}

	@DisplayName("checkSelectedNumber 정상 동작 확인")
	@Test
	void checkSelectedNumber() {
		BallNumberVo selectedNumber = new BallNumberVo();
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		selectedNumber.setNumbers(numbers);
		assertThat(BallNumberUtil.checkSelectedNumber(selectedNumber)).isTrue();
	}

	@DisplayName("checkSelectedNumber 비정상 사이즈 체크")
	@Test
	void checkSelectedNumberInvalidSize() {
		BallNumberVo selectedNumber = new BallNumberVo();

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		selectedNumber.setNumbers(numbers);
		assertThat(BallNumberUtil.checkSelectedNumber(selectedNumber)).isFalse();
	}

	@DisplayName("checkSelectedNumber 범위 외의 숫자")
	@Test
	void checkSelectedNumberInvalidNumber() {
		BallNumberVo selectedNumber = new BallNumberVo();

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(0);

		assertThat(BallNumberUtil.checkSelectedNumber(selectedNumber)).isFalse();
	}

	@DisplayName("checkSelectedNumber 중복 숫자")
	@Test
	void checkSelectedNumberDuplicatNumber() {
		BallNumberVo selectedNumber = new BallNumberVo();

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(2);

		assertThat(BallNumberUtil.checkSelectedNumber(selectedNumber)).isFalse();
	}

	@DisplayName("stringToBallNumber 정상 동작 확인")
	@Test
	void stringToBallNumber() {
		BallNumberVo ballNumber = BallNumberUtil.stringToBallNumber("1,2,3");
		assertThat(ballNumber).isNotNull();

		List<Integer> numbers = ballNumber.getNumbers();

		assertThat(numbers).isNotNull();
		assertThat(numbers.get(0)).isEqualTo(1);
		assertThat(numbers.get(1)).isEqualTo(2);
		assertThat(numbers.get(2)).isEqualTo(3);
	}
}
