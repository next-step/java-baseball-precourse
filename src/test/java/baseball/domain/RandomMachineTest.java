package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;


class RandomMachineTest {

	@Test
	public void 랜덤_숫자_사이즈(){
		//given
		//when
		int size = new RandomMachine().getNumber().size();
		//then
		assertThat(size).isEqualTo(3);
	}
	@Test
	void 랜덤_숫자_생성(){

		for(int i=0;i<100;i++){
			//given
			RandomMachine randomMachine = new RandomMachine();
			// when
			List<Integer> numbers = randomMachine.getNumber();
			int size1 = numbers.stream().filter(a->a.equals(numbers.get(0))).collect(Collectors.toList()).size();
			int size2 = numbers.stream().filter(a->a.equals(numbers.get(1))).collect(Collectors.toList()).size();
			int size3 = numbers.stream().filter(a->a.equals(numbers.get(2))).collect(Collectors.toList()).size();

			//then
			assertThat(size1).isEqualTo(1);
			assertThat(size2).isEqualTo(1);
			assertThat(size3).isEqualTo(1);
		}

	}
}
