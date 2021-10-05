package baseball;

import java.io.ByteArrayInputStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputTest {
	@Test
	void convert_string_to_numeric_list(){
		input("123");

		BaseballNumbers baseballNumbers = Input.readPlayerBaseballNumbers();

		Assertions.assertThat(baseballNumbers.getBaseballNumbers())
			.containsExactly(1,2,3);
	}

	private void input(String value){
		ByteArrayInputStream inputStream = new ByteArrayInputStream(value.getBytes());
		System.setIn(inputStream);
	}

}