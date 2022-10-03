package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballTest {

	@Test
	public void Baseball객체_확인() {
		Baseball baseball = Baseball.of(1);
		assertThat(baseball).isInstanceOf(Baseball.class);
	}

	@Test
	public void Baseball숫자_예외_처리() {
		assertThatThrownBy(() -> {
			Baseball baseball = Baseball.of(10);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}