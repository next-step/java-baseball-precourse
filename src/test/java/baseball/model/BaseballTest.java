package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.result.Result;

public class BaseballTest {

	Baseball baseball = Baseball.getInstance();
	Field fNumbers;

	@BeforeEach
	void setup() throws Exception {
		fNumbers = Baseball.class.getDeclaredField("numbers");
		fNumbers.setAccessible(true);
	}

	@Test
	@DisplayName("초기화시 랜덤숫자는 3자리여야한다")
	void testInitialize_sizeShouldBeThree() throws Exception {
		//숫자 3자리 초기화
		baseball.initialize();
		List<Integer> findNumbers = getNumbers();

		assertThat(findNumbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("초기화할 때마다 랜덤숫자는 달라져야 한다")
	void testInitialize_ShouldBeDifferentNumbersEveryTimeInitializing() throws Exception {
		baseball.initialize();
		List<Integer> numbersA = new ArrayList<>(getNumbers());

		baseball.initialize();
		List<Integer> numbersB = new ArrayList<>(getNumbers());

		baseball.initialize();
		List<Integer> numbersC = new ArrayList<>(getNumbers());

		assertThat(isSameList(numbersA, numbersB)).isFalse();
		assertThat(isSameList(numbersB, numbersC)).isFalse();
	}

	@Test
	@DisplayName("숫자 2개가 위치까지 맞았을 때 결과 실패와 '2스트라이크' 메시지가 나온다")
	void testCheckIfTheAnswerIsCorrect_fail_twoStrike() throws Exception {
		baseball.initialize();
		List<Integer> numbers = getNumbers();

		int number = getNumberNotContaining(numbers);

		List<Integer> inputNumbers = Arrays.asList(numbers.get(0), numbers.get(1), number);
		Result result = baseball.checkIfTheAnswerIsCorrect(inputNumbers);

		assertThat(result.isSuccessful()).isFalse();
		assertThat(result.getMessage().trim()).isEqualTo("2스트라이크");



	}

	@Test
	@DisplayName("숫자 2개 중 1개는 위치가 맞고 1개는 틀릴 때 결과 실패와 '1스트라이크 1볼' 메시지가 나온다")
	void testCheckIfTheAnswerIsCorrect_fail_oneStrikeAndOneBall() throws Exception {
		baseball.initialize();
		List<Integer> numbers = getNumbers();

		int number = getNumberNotContaining(numbers);

		List<Integer> inputNumbers = Arrays.asList(number, numbers.get(1), numbers.get(0));
		Result result = baseball.checkIfTheAnswerIsCorrect(inputNumbers);

		assertThat(result.isSuccessful()).isFalse();
		assertThat(result.getMessage().trim()).isEqualTo("1스트라이크 1볼");
	}

	@Test
	@DisplayName("숫자 모두 틀릴 때 결과 실패와 '낫싱' 메시지가 나온다")
	void testCheckIfTheAnswerIsCorrect_fail_nothing() throws Exception {
		baseball.initialize();
		List<Integer> numbers = getNumbers();

		int number1 = getNumberNotContaining(numbers);
		int number2 = getNumberNotContaining(numbers);
		int number3 = getNumberNotContaining(numbers);
		List<Integer> inputNumbers = Arrays.asList(number1, number2, number3);
		Result result = baseball.checkIfTheAnswerIsCorrect(inputNumbers);

		assertThat(result.isSuccessful()).isFalse();
		assertThat(result.getMessage().trim()).isEqualTo("낫싱");
	}

	@Test
	@DisplayName("결과 모두 맞을 때 결과 성공과 '3스트라이크' 메시지가 나온다")
	void testCheckIfTheAnswerIsCorrect_resultIsSuccess() throws Exception {
		baseball.initialize();
		List<Integer> numbers = getNumbers();

		List<Integer> inputNumbers = Arrays.asList(numbers.get(0), numbers.get(1), numbers.get(2));
		Result result = baseball.checkIfTheAnswerIsCorrect(inputNumbers);

		assertThat(result.isSuccessful()).isTrue();
		assertThat(result.getMessage()).isEqualTo("3스트라이크 \n3개의 숫자를 모두 맞히셨습니다!");
	}

	private List<Integer> getNumbers() throws Exception{
		return (List<Integer>)fNumbers.get(baseball);
	}

	private int getNumberNotContaining(List<Integer> randomNumbers) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

		for (Integer number : numbers) {
			if (!randomNumbers.contains(number)) {
				return number;
			}
		}

		return 0;
	}

	private boolean isSameList(List<Integer> listA, List<Integer> listB) {
		if (!listA.containsAll(listB)) {
			return false;
		}

		for(int i=0; i<listA.size(); i++) {
			if (!listA.get(i).equals(listB.get(i))) {
				return false;
			}
		}

		return true;
	}
}
