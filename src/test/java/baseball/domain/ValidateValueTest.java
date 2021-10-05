package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class ValidateValueTest {

	@Nested
	@DisplayName("isNum method는")
	class Describe_isNum {
		private ValidateValue validateValue = new ValidateValue();
		private String crtInput = "123";
		private String errInput = "ball";

		@Nested
		@DisplayName("입력 값으로 숫자가 주어진다면")
		class Context_with_num {
			@DisplayName("True를 반환한다.")
			@Test
			void it_returns_true() {
				assertThat(validateValue.isNum(crtInput)).isTrue();
			}
		}


		@Nested
		@DisplayName("입력 값으로 숫자가 아닌 것이 주어진다면")
		class Context_with_not_num {
			@DisplayName("False를 반환한다.")
			@Test
			void it_return_false() {
				assertThat(validateValue.isNum(errInput)).isFalse();
			}
		}
	}


	@Nested
	@DisplayName("isCorrectLength method는")
	class Describe_isCorrectLength {
		private ValidateValue validateValue = new ValidateValue();
		private String crtInput = "123";
		private String errInput = "12345";

		@Nested
		@DisplayName("입력 값으로 세 자리 숫자가 주어진다면")
		class Context_with_len_three {
			@DisplayName("True를 반환한다.")
			@Test
			void it_returns_true() {
				assertThat(validateValue.isCorrectLength(crtInput)).isTrue();
			}
		}

		@Nested
		@DisplayName("입력 값으로 세 자리가 아닌 숫자가 주어진다면")
		class Context_with_len_not_three {
			@DisplayName("False를 반환한다.")
			@Test
			void it_return_false() {
				assertThat(validateValue.isCorrectLength(errInput)).isFalse();
			}
		}
	}

	@Nested
	@DisplayName("isDiffNum method는")
	class Describe_isDiffNum {
		private ValidateValue validateValue = new ValidateValue();
		private String crtInput = "123";
		private String errInput = "111";

		@Nested
		@DisplayName("입력 값으로 세 자리 다른 숫자가 주어진다면")
		class Context_with_diff_num {
			@DisplayName("True를 반환한다.")
			@Test
			void it_returns_true() {
				assertThat(validateValue.isDiffNum(crtInput)).isTrue();
			}
		}

		@Nested
		@DisplayName("입력 값으로 중복되는 숫자가 주어진다면")
		class Context_with_not_diff_num {
			@DisplayName("False를 반환한다.")
			@Test
			void it_return_false() {
				assertThat(validateValue.isDiffNum(errInput)).isFalse();
			}
		}
	}


}
