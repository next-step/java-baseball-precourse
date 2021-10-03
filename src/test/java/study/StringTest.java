package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@DisplayName("\"1,2\"를 \",\"로 split했을 때 1과 2로 잘 분리되는지 확인")
	@Test
	void splitTestForOneTwoWithComma() {
		assertThat("1,2".split(","))
			.containsExactly("1", "2");
	}
}
