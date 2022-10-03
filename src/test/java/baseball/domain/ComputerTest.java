package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    Computer computer;

    @BeforeEach
    void beforeEach(){
        computer = new Computer();
        computer.init();
    }

    @Test
    void 맞춰야할_숫자_생성_테스트(){

        // 객체 생성 및 3자리 세팅이 잘 되는지
        assertThat(computer).isNotNull();
        assertThat(computer.getNumbers()).isNotNull();

    }

    @Test
    @DisplayName("생성 난수의 길이 체크")
    void 생성_난수_자리수_테스트(){
        assertThat(computer.getNumbers().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints={0,1,2})
    void 숫자_이외_문자_존재_여부_테스트(int index){
        assertThat(computer.getNumbers().get(index)).isInstanceOf(Integer.class);
    }

    @ParameterizedTest
    @ValueSource(ints={0,1,2})
    void 숫자_범위_테스트(int index){
        assertThat(computer.getNumbers().get(index)).isGreaterThanOrEqualTo(1);
        assertThat(computer.getNumbers().get(index)).isLessThanOrEqualTo(9);
    }

    @Test
    void 중복_숫자_존재_여부_테스트(){
        List<Integer> numbers = computer.getNumbers();
        assertThat(
                !numbers.get(0).equals(numbers.get(1)) &&
                        !numbers.get(1).equals(numbers.get(2)) &&
                        !numbers.get(2).equals(numbers.get(0))
        ).isTrue();
    }

    @Test
    void 랜덤_유틸_테스트(){
        Set<Integer> set = new HashSet<>();

        while(set.size() < 3){
            set.add(Randoms.pickNumberInRange(1,9));
            System.out.println("set.size() = " + set.size());
        }

        assertThat(set.size()).isEqualTo(3);
    }

}