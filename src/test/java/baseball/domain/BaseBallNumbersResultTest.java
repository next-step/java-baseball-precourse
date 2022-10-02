package baseball.domain;

import static baseball.domain.BaseBallNumbers.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class BaseBallNumbersResultTest {

	@ParameterizedTest
	@CsvSource(value = { "2:4:6:BALL:BALL:NOTHING"
		,"1:2:3:NOTHING:STRIKE:NOTHING"
		,"2:4:5:BALL:BALL:STRIKE"
		,"7:8:9:NOTHING:NOTHING:NOTHING"
		,"4:2:5:STRIKE:STRIKE:STRIKE"
	},delimiterString = ":")
	void 숫자_선택_결과_확인(int first, int second, int third, Status status1, Status status2, Status status3) {

		//given
		BaseBallNumbers computerNumbers
			= new BaseBallNumbers(Arrays.asList(
			BaseBallNumber.of(1,4)
			, BaseBallNumber.of(2,2)
			, BaseBallNumber.of(3,5)));

		BaseBallNumbers meNumbers
			= new BaseBallNumbers(Arrays.asList(
			BaseBallNumber.of(1,first)
			, BaseBallNumber.of(2,second)
			, BaseBallNumber.of(3,third)));

		//when
		meNumbers.isSuccessCatching(computerNumbers);

		//then
		List<BaseBallNumber> list = meNumbers.getList();

		int index = 0;
		assertThat(status1).isEqualTo(list.get(index++).currentStatus());
		assertThat(status2).isEqualTo(list.get(index++).currentStatus());
		assertThat(status3).isEqualTo(list.get(index++).currentStatus());

	}

	@ParameterizedTest
	@CsvSource(value = { "2:4:6:false"
		,"1:2:3:false"
		,"2:4:5:false"
		,"7:8:9:false"
		,"4:2:5:true"
	},delimiterString = ":")
	void 숫자_선택_결과_출력(int first, int second, int third, boolean flag) {

		//given
		BaseBallNumbers computerNumbers
			= new BaseBallNumbers(Arrays.asList(
			BaseBallNumber.of(1,4)
			, BaseBallNumber.of(2,2)
			, BaseBallNumber.of(3,5)));

		BaseBallNumbers meNumbers
			= new BaseBallNumbers(Arrays.asList(
			BaseBallNumber.of(1,first)
			, BaseBallNumber.of(2,second)
			, BaseBallNumber.of(3,third)));

		//when
		boolean resultFlag = meNumbers.isSuccessCatching(computerNumbers);
		//then
		assertThat(flag).isEqualTo(resultFlag);

	}

	@ParameterizedTest
	@CsvSource(value = { "2:4:6"},delimiterString = ":")
	void 숫자_생성(int first, int second, int third){
		//given
		List<Integer> baseBallRandomNumbers = Arrays.asList(first,second,third);
		//when
		BaseBallNumbers numbers = createNumber(baseBallRandomNumbers);
		int index = 0;
		System.out.println(numbers);
		//then
		assertThat(BaseBallNumber.of(1,first)).isEqualTo(numbers.getList().get(index++));
		assertThat(BaseBallNumber.of(2,second)).isEqualTo(numbers.getList().get(index++));
		assertThat(BaseBallNumber.of(3,third)).isEqualTo(numbers.getList().get(index++));
	}

	@Test
	void 랜덤_숫자_생성(){

		for(int i=0;i<100;i++){
			//given
			// when
			BaseBallNumbers numbers = createComputeNumber();

			int size1 = numbers.getList().stream().filter(a->a.equals(numbers.getList().get(0))).collect(Collectors.toList()).size();
			int size2 = numbers.getList().stream().filter(a->a.equals(numbers.getList().get(1))).collect(Collectors.toList()).size();
			int size3 = numbers.getList().stream().filter(a->a.equals(numbers.getList().get(2))).collect(Collectors.toList()).size();

			//then
			assertThat(size1).isEqualTo(1);
			assertThat(size2).isEqualTo(1);
			assertThat(size3).isEqualTo(1);
		}

	}

	@Test
	void 숫자_인풋값_스플릿(){
		//given
		String str = "481";
		//when
		BaseBallNumbers baseBallNumbers = createBaseBallNumbers(str);
		//then
		assertThat(BaseBallNumber.of(1,4)).isEqualTo(baseBallNumbers.getList().get(0));
		assertThat(BaseBallNumber.of(2,8)).isEqualTo(baseBallNumbers.getList().get(1));
		assertThat(BaseBallNumber.of(3,1)).isEqualTo(baseBallNumbers.getList().get(2));

	}

}
