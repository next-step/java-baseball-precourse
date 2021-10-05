package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import nextstep.test.NSTest;

class UserTest extends NSTest {
	@BeforeEach
	void beforeEach() {
		super.setUp();
	}

	@ParameterizedTest
	@CsvSource(value = {"abc:1 ~ 9 까지의 숫자만 입력해주세요.:123", "123456:세 자리를 입력해주세요:123",
		"112:입력값 중 중복된 값이 있습니다. 서로 다른 숫자를 입력해주세요.:123"}, delimiter = ':')
	void 숫자_입력_테스트(String wrongInput, String message, String correctInput) {
		run(wrongInput, correctInput);
		User.getNumberInput();
		verify(message);
	}

	@ParameterizedTest
	@CsvSource(
		value = {
			"3:잘못된 값을 입력하셨습니다. 다시 시작하시려면 1, 게임을 종료하시려면 2를 입력해주세요.:1"
			, "4:잘못된 값을 입력하셨습니다. 다시 시작하시려면 1, 게임을 종료하시려면 2를 입력해주세요.:2"
		}
		, delimiter = ':'
	)
	void 다시_시작_OR_완전_종료_입력_테스트(String wrongInput, String message, String correctInput) {
		run(wrongInput, correctInput);
		User.getRestartInput();
		verify(message);
	}

	@Override
	public void runMain() {
	}
}
