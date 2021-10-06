package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("split 함수 테스트")
	@Test
	void split() {
		String numStr = "1,2";
		String[] tokens = numStr.split(",");

		assertAll(
			() -> assertThat(tokens).containsExactly("1", "2"),
			() -> assertThat(tokens).contains("1"),
			() -> assertThat(tokens).contains("2")
		);
	}

}
