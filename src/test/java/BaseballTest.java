import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballTest {
	private Baseball model;

	@BeforeEach
	void setUp() {
		model = new Baseball();
		model.init();
	}

	@ParameterizedTest
	@ValueSource(ints = {123, 129, 421, 426, 987, 493})
	void isValidNumber_ShouldReturnTrueForValidNumber(int number) {
		assertThat(model.isValidNumber(number)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 112, 120, 409, 733, 222, 11, 3, 54269})
	void isValidNumber_ShouldReturnFalseForInvalidNumber(int number) {
		assertThat(model.isValidNumber(number)).isFalse();
	}

	@Test
	void init_ShouldSetCorrectNumber() {
		for (int i = 0; i < 100; i++) {
			int number = model.getComputerNumber();
			assertThat(model.isValidNumber(number)).isTrue();
			model.init();
		}
	}

	@Test
	void compareNumber_ShouldReturnThreeStrikeResultForSameNumber() {
		for (int i = 0; i < 100; i++) {
			int number = model.getComputerNumber();
			BaseballResult result = model.compareNumber(number);
			assertThat(result.isThreeStrike()).isTrue();
		}
	}

	@ParameterizedTest
	@CsvSource({"123,125", "965,975"})
	void compareNumber_ShouldReturnTwoStrikeResult(int computerNumber, int userNumber) {
		model.setComputerNumber(computerNumber);
		BaseballResult result = model.compareNumber(userNumber);
		assertThat(result.getStrike() == 2 && result.getBall() == 0).isTrue();
	}

	@ParameterizedTest
	@CsvSource({"173,135", "965,954"})
	void compareNumber_ShouldReturnOneStrikeOneBallResult(int computerNumber, int userNumber) {
		model.setComputerNumber(computerNumber);
		BaseballResult result = model.compareNumber(userNumber);
		assertThat(result.getStrike() == 1 && result.getBall() == 1).isTrue();
	}

	@ParameterizedTest
	@CsvSource({"713,135", "695,954"})
	void compareNumber_ShouldReturnTwoBallResult(int computerNumber, int userNumber) {
		model.setComputerNumber(computerNumber);
		BaseballResult result = model.compareNumber(userNumber);
		assertThat(result.getStrike() == 0 && result.getBall() == 2).isTrue();
	}

	@ParameterizedTest
	@CsvSource({"123,312", "695,956"})
	void compareNumber_ShouldReturnThreeBallResult(int computerNumber, int userNumber) {
		model.setComputerNumber(computerNumber);
		BaseballResult result = model.compareNumber(userNumber);
		assertThat(result.getStrike() == 0 && result.getBall() == 3).isTrue();
	}

	@ParameterizedTest
	@CsvSource({"123,456", "695,784"})
	void compareNumber_ShouldReturnNothingResult(int computerNumber, int userNumber) {
		model.setComputerNumber(computerNumber);
		BaseballResult result = model.compareNumber(userNumber);
		assertThat(result.isNothing()).isTrue();
	}
}
