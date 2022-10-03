package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballsTest {

	@Test
	public void Baseball객체_생성() {
		Baseballs myBaseballs = Baseballs.createBaseballs("123");
		assertThat(myBaseballs).isInstanceOf(Baseballs.class);
	}

	@Test
	public void randomBaseball_객체_생성() {
		Baseballs comBaseballs = Baseballs.createRandomBaseballs();
		assertThat(comBaseballs).isInstanceOf(Baseballs.class);
	}

	@Test
	public void 숫자_길이_체크_예외처리() {
		assertThatThrownBy(() -> {
			Baseballs.createBaseballs("1234");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 숫자_중복_체크_예외처리() {
		assertThatThrownBy(() -> {
			Baseballs.createBaseballs("122");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 스트라이크_카운트() {
		Baseballs myBaseballs = Baseballs.createBaseballs("597");
		Baseballs comBaseballs = Baseballs.createBaseballs("589");
		assertThat(myBaseballs.countStrike(comBaseballs)).isEqualTo(1);
	}

	@Test
	public void 볼_카운트() {
		Baseballs myBaseballs = Baseballs.createBaseballs("597");
		Baseballs comBaseballs = Baseballs.createBaseballs("589");
		assertThat(myBaseballs.countBall(comBaseballs)).isEqualTo(1);
	}
}