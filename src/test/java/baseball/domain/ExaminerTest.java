package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExaminerTest {

	@Test
	@DisplayName("출제자는_랜덤한_정답을_가진다")
	void 출제자는_랜덤한_정답을_가진다(){

		Examiner examiner = new Examiner();

		Numbers goalNumber = examiner.getGoal();

		List<Number> digits = goalNumber.getNumber();
		assertThat(digits).isNotEmpty().hasSize(3);

	}

}