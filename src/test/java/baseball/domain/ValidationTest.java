package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ValidationTest {

	@Nested
	@DisplayName("isNum method는")
	class Describe_isNum {
		private Validation validation = new Validation();
		private String crtInput = "123";
		private String errInput = "ball";

		@Nested
		@DisplayName("입력 값으로 숫자가 주어진다면")
		class Context_with_num {
			@DisplayName("True를 반환한다.")
			@Test
			void it_returns_true() {
				assertThat(validation.isNum(crtInput)).isTrue();
			}
		}


		@Nested
		@DisplayName("입력 값으로 숫자가 아닌 것이 주어진다면")
		class Context_with_not_num {
			@DisplayName("False를 반환한다.")
			@Test
			void it_return_false() {
				assertThat(validation.isNum(errInput)).isFalse();
			}
		}
	}


	@Nested
	@DisplayName("isCorrectLength method는")
	class Describe_isCorrectLength {
		private Validation validation = new Validation();
		private String crtInput = "123";
		private String errInput = "12345";

		@Nested
		@DisplayName("입력 값으로 세 자리 숫자가 주어진다면")
		class Context_with_len_three {
			@DisplayName("True를 반환한다.")
			@Test
			void it_returns_true() {
				assertThat(validation.isCorrectLength(crtInput)).isTrue();
			}
		}

		@Nested
		@DisplayName("입력 값으로 세 자리가 아닌 숫자가 주어진다면")
		class Context_with_len_not_three {
			@DisplayName("False를 반환한다.")
			@Test
			void it_return_false() {
				assertThat(validation.isCorrectLength(errInput)).isFalse();
			}
		}
	}

	@Nested
	@DisplayName("isDiffNum method는")
	class Describe_isDiffNum {
		private Validation validation = new Validation();
		private String crtInput = "123";
		private String errInput = "111";

		@Nested
		@DisplayName("입력 값으로 세 자리 다른 숫자가 주어진다면")
		class Context_with_diff_num {
			@DisplayName("True를 반환한다.")
			@Test
			void it_returns_true() {
				assertThat(validation.isDiffNum(crtInput)).isTrue();
			}
		}

		@Nested
		@DisplayName("입력 값으로 중복되는 숫자가 주어진다면")
		class Context_with_not_diff_num {
			@DisplayName("False를 반환한다.")
			@Test
			void it_return_false() {
				assertThat(validation.isDiffNum(errInput)).isFalse();
			}
		}
	}


}
