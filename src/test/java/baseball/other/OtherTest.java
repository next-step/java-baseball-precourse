package baseball.other;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OtherTest {

	@Test
	@DisplayName("Randoms.pickNumberInRange 테스트")
	public void test1() throws Exception{
		int i = Randoms.pickNumberInRange(100, 999);
		System.out.println(i);
		Assertions.assertThat(i)
				.isGreaterThanOrEqualTo(100)
				.isLessThanOrEqualTo(999);
	}

}
