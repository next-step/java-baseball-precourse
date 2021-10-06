package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CountingTest {

	@Nested
	@DisplayName("isCorrectAnswer method는")
	class Describe_isCorrectAnswer {
		private final Counting counting = new Counting();
		public final String crtUserInput = "123";
		public final String errUserInput = "123";
		public final Integer crtAnswerNum = 123;
		public final Integer errAnswerNum = 456;

		@Nested
		@DisplayName("입력 값이 정답이라면")
		class Context_with_answer {
			@DisplayName("True를 반환한다.")
			@Test
			void it_returns_true() {
				assertThat(counting.isCorrectAnswer(crtUserInput, crtAnswerNum)).isTrue();
			}

			@ParameterizedTest
			@CsvSource(value={"456, 456", "123, 123"})
			@DisplayName("True를 반환한다.")
			void it_returns_true_also(String input, Integer answer) {
				assertThat(counting.isCorrectAnswer(input, answer)).isTrue();
			}
		}

		@Nested
		@DisplayName("입력 값이 정답이 아니라면")
		class Context_with_wrg_answer {
			@DisplayName("False를 반환한다.")
			@Test
			void it_returns_false() {
				assertThat(counting.isCorrectAnswer(errUserInput, errAnswerNum)).isFalse();
			}

			@ParameterizedTest
			@CsvSource(value={"456, 123", "789, 123"})
			@DisplayName("False를 반환한다.")
			void it_returns_true_also(String input, Integer answer) {
				assertThat(counting.isCorrectAnswer(input, answer)).isFalse();
			}
		}
	}

	@Nested
	@DisplayName("strikeCounting method는")
	class Describe_strikeCounting {
		private final Counting counting = new Counting();
		private final List<Integer> ctrInputNumList = Arrays.asList(1, 2, 3);
		private final List<Integer> crtAnswerNumList =  Arrays.asList(1, 2, 5);


		@Nested
		@DisplayName("입력 값이 두 개가 같은 숫자, 같은 자리라면")
		class Context_with_two_strike {
			@DisplayName("2를 반환한다.")
			@Test
			void it_returns_two() {
				assertThat(counting.strikeCounting(crtAnswerNumList, ctrInputNumList)).isEqualTo(2);
			}
		}
	}

	@Nested
	@DisplayName("ballCounting method는")
	class Describe_ballCounting {
		private final Counting counting = new Counting();
		private final List<Integer> ctrInputNumList = Arrays.asList(1, 2, 3);
		private final List<Integer> crtAnswerNumList =  Arrays.asList(2, 3, 5);


		@Nested
		@DisplayName("입력 값이 두 개가 같은 숫자, 다른 자리라면")
		class Context_with_two_ball {
			@DisplayName("2를 반환한다.")
			@Test
			void it_returns_two() {
				assertThat(counting.ballCounting(crtAnswerNumList, ctrInputNumList)).isEqualTo(2);
			}
		}
	}
}
