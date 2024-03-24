package gameLogics;

import controller.GameController;
import dto.State;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import static gameLogics.BaseRule.GAME_NUMBER_LENGTH;

@DisplayName("게임 초기화 기능 테스트")
class InitiatingSequenceTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp(){
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
	}
	@Test
	@DisplayName("정답 생성 기능 테스트")
	void generateAnswer() {
		List<Integer> ans = InitiatingSequence.generateAnswer();
		assertThat(ans.size()).isEqualTo(GAME_NUMBER_LENGTH);
		int counter = 0;
		int idx = -1;
		while (++idx < GAME_NUMBER_LENGTH){
			if (numbers.contains(ans.get(idx)))
				counter++;
		}
		assertThat(counter).isEqualTo(GAME_NUMBER_LENGTH);
	}

	@Test
	@DisplayName("초기 상태 생성 테스트")
	void getInitialState() {
		State state = InitiatingSequence.getInitialState();
		assertThat(state.getBall()).isEqualTo(0);
		assertThat(state.getStrike()).isEqualTo(0);
	}
}