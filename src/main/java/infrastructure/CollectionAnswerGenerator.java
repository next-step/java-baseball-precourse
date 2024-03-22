package infrastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.AnswerGenerator;
import domain.Score;

public class CollectionAnswerGenerator implements AnswerGenerator {
	private static final List<Integer> numList = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));

	@Override
	public String generateAnswer() {
		StringBuilder builder = new StringBuilder();

		Collections.shuffle(numList);
		for (int i = 0; i < Score.ANSWER_LENGTH; i++) {
			builder.append(numList.get(i));
		}

		return builder.toString();
	}
}
