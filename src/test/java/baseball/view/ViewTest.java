package baseball.view;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewTest {

	View view = View.getInstance();

	@Test
	@DisplayName("입력 숫자가 세자리가 아닐 경우 false가 나온다")
	void testValidateIfThreeNumbers_fail_sizeShouldBeThree() throws Exception {
		String input = "12";
		boolean result = executeValidateIfThreeNumbers(input);

		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("입력한 타입이 숫자가 아닐 경우 false가 나온다")
	void testValidateIfThreeNumbers_fail_typeShouldBeNumber() throws Exception {
		String input = "12v";

		boolean result = executeValidateIfThreeNumbers(input);

		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("입력한 타입이 숫자이고, 세자리일 경우 true가 나온다")
	void testValidateIfThreeNumbers_success() throws Exception {
		String input = "123";

		boolean result = executeValidateIfThreeNumbers(input);

		assertThat(result).isTrue();
	}


	private boolean executeValidateIfThreeNumbers(String input) throws Exception {
		Method method =
			view.getClass().getDeclaredMethod("validateIfThreeNumbers", String.class);
		method.setAccessible(true);

		return (boolean) method.invoke(view, input);
	}

	@Test
	@DisplayName("재시작여부 입력 요청시 입력한 타입이 문자일 경우 false가 나온다")
	void testValidateIfItIsOneOrTwo_fail_typeShouldBeNumber() throws Exception {
		String input = "t";

		boolean result = executeValidateIfItIsOneOrTwo(input);

		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("재시작여부 입력 요청시 입력한 숫자가 1또는 2가 아닐 경우 false가 나온다")
	void testValidateIfItIsOneOrTwo_fail_numberShouldBeOnlyOneOrTwo() throws Exception {
		String input = "3";

		boolean result = executeValidateIfItIsOneOrTwo(input);

		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("재시작여부 입력 요청시 입력한 숫자가 1또는 2일 경우 true가 나온다")
	void testValidateIfItIsOneOrTwo_success() throws Exception {
		String input = "1";
		boolean result = executeValidateIfItIsOneOrTwo(input);
		assertThat(result).isTrue();

		input = "2";
		result = executeValidateIfItIsOneOrTwo(input);
		assertThat(result).isTrue();
	}

	private boolean executeValidateIfItIsOneOrTwo(String input) throws Exception {
		Method method =
			view.getClass().getDeclaredMethod("validateIfItIsOneOrTwo", String.class);
		method.setAccessible(true);

		return (boolean) method.invoke(view, input);
	}
}
