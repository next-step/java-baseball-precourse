package infrastructure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.AnswerGenerator;
import domain.Score;

class CollectionAnswerGeneratorTest {
	private AnswerGenerator collectionAnswerGenerator;

	@BeforeEach
	void setUp() {
		collectionAnswerGenerator = new CollectionAnswerGenerator();
	}

	@Test
	void 길이_3의_다른_숫자로_이뤄진_랜덤한_숫자_문자열을_생성한다() {
		// given, when : Generator 클래스의 숫자 생성
		String generated = collectionAnswerGenerator.generateAnswer();

		// then 1 : 생성된 문자열의 길이가 3이다
		assertEquals(Score.ANSWER_LENGTH, generated.length());

		// then 2 : 생성된 문자열의 각 숫자가 모두 다르다
		HashSet<Character> set = new HashSet<>();
		for (char c : generated.toCharArray()) {
			set.add(c);
		}
		assertEquals(generated.length(), set.size());
	}
}