package baseball.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.util.BallNumberUtil;
import baseball.vo.BallNumberVo;

public class SelectedNumberTest {

	@DisplayName("createSelectedNumberList 정상 동작 확인")
	@Test
	void create() {
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
		assertThat(BallNumberUtil.checkSelectedNumber(selectedNumber)).isTrue();
	}

	@DisplayName("checkSelectedNumber 범위 외의 숫자")
	@Test
	void checkSelectedNumberInvalidNumber() {
		BallNumberVo selectedNumber = new BallNumberVo();

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(0);

		assertThat(BallNumberUtil.checkSelectedNumber(selectedNumber)).isTrue();
	}

	@DisplayName("checkSelectedNumber 중복 숫자")
	@Test
	void checkSelectedNumberDuplicatNumber() {
		BallNumberVo selectedNumber = new BallNumberVo();

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(2);

		assertThat(BallNumberUtil.checkSelectedNumber(selectedNumber)).isTrue();
	}
}
