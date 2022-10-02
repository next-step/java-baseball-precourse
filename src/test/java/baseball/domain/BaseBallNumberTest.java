package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

class BaseBallNumberTest {


	@Test
	void 랜덤_숫자_확인() {
		System.out.println(Randoms.pickNumberInRange(1, 9));
	}

	@Test
	void 스트라이크_확인(){
		BaseBallNumber ball = BaseBallNumber.of(1, 9);
		BaseBallNumber targetBall = BaseBallNumber.of(1,9);
		assertThat(ball.isStrike(targetBall)).isTrue();
	}

	@Test
	void 볼_확인(){
		BaseBallNumber ball = BaseBallNumber.of(1, 9);
		BaseBallNumber targetBall = BaseBallNumber.of(2,9);
		assertThat(ball.isBall(targetBall)).isTrue();
	}

	@Test
	void 나씽_확인(){
		BaseBallNumber ball = BaseBallNumber.of(1, 3);
		BaseBallNumber targetBall = BaseBallNumber.of(1,9);
		assertThat(ball.isNothing(targetBall)).isTrue();
	}
}
