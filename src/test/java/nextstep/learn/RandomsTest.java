package nextstep.learn;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nextstep.utils.Randoms;

public class RandomsTest {

	@Test
	void pickRandom(){
		int random = Randoms.pickNumberInRange(1, 999);

		assertThat(random)
			.isGreaterThan(0)
			.isLessThan(1000);
	}
}
