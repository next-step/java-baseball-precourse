package gameLogics;

import dto.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static gameLogics.BaseRule.GAME_NUMBER_LENGTH;


@DisplayName("이닝 플레이 테스트")
class InningSequenceTest {

	@Test
	@DisplayName("종료조건 확인 테스트")
	void checkEndState() {
		State state = new State(GAME_NUMBER_LENGTH, 0);
		assertThat(InningSequence.checkEndState(state)).isEqualTo(true);
		state = new State();
		assertThat(InningSequence.checkEndState(state)).isEqualTo(false);
		state = new State(GAME_NUMBER_LENGTH-1,1);
		assertThat(InningSequence.checkEndState(state)).isEqualTo(false);
		state = new State(0, GAME_NUMBER_LENGTH);
		assertThat(InningSequence.checkEndState(state)).isEqualTo(false);
	}

	@Test
	@DisplayName("이닝 플레이 테스트 - 정답")
	void playInning1() {
		List<Integer> answer;
		List<Integer> pitch;

		answer = new ArrayList<>();
		answer.add(1);
		answer.add(6);
		answer.add(2);
		pitch = new ArrayList<>();
		pitch.add(1);
		pitch.add(6);
		pitch.add(2);

		State state = new State();

		InningSequence.playInning(answer, pitch, state);
		assertThat(state.getStrike()).isEqualTo(3);
		assertThat(state.getBall()).isEqualTo(0);
	}

	@Test
	@DisplayName("이닝 플레이 테스트 - 오답1")
	void playInning2() {
		List<Integer> answer;
		List<Integer> pitch;

		answer = new ArrayList<>();
		answer.add(1);
		answer.add(6);
		answer.add(2);
		pitch = new ArrayList<>();
		pitch.add(1);
		pitch.add(2);
		pitch.add(6);

		State state = new State();

		InningSequence.playInning(answer, pitch, state);
		assertThat(state.getStrike()).isEqualTo(1);
		assertThat(state.getBall()).isEqualTo(2);
	}

	@Test
	@DisplayName("이닝 플레이 테스트 - 오답2")
	void playInning3() {
		List<Integer> answer;
		List<Integer> pitch;

		answer = new ArrayList<>();
		answer.add(1);
		answer.add(8);
		answer.add(2);
		pitch = new ArrayList<>();
		pitch.add(1);
		pitch.add(2);
		pitch.add(6);

		State state = new State();

		InningSequence.playInning(answer, pitch, state);
		assertThat(state.getStrike()).isEqualTo(1);
		assertThat(state.getBall()).isEqualTo(1);
	}

	@Test
	@DisplayName("이닝 플레이 테스트 - 오답3")
	void playInning4() {
		List<Integer> answer;
		List<Integer> pitch;

		answer = new ArrayList<>();
		answer.add(1);
		answer.add(8);
		answer.add(6);
		pitch = new ArrayList<>();
		pitch.add(2);
		pitch.add(4);
		pitch.add(3);

		State state = new State();

		InningSequence.playInning(answer, pitch, state);
		assertThat(state.getStrike()).isEqualTo(0);
		assertThat(state.getBall()).isEqualTo(0);
	}
}