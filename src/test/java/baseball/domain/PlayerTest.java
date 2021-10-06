package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

	// 무조건 123을 입력한다
	@BeforeAll
	static void setUp(){
		ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
		System.setIn(in);
		System.setIn(System.in);
	}

	@Test
	@DisplayName("플레이어_입력")
	void 플레이어_입력(){
		Player player = new Player();
		Numbers exceptNumbers = new Numbers("123");

		player.inputAnswer();

		Numbers answer = player.getAnswer();
		assertThat(answer).isEqualTo(exceptNumbers);
	}
}