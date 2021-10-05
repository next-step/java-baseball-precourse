//package baseball.generator;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//
//class HintGeneratorTest {
//
//    @Test
//    @DisplayName("모두 맞추면 3스트라이크")
//    void getHint_strike()  {
//        //given
//        List<Integer> answer = 세자리수만들기(1,3,5);
//        List<Integer> input = 세자리수만들기(1,3,5);
//        //when
//        final HintGenerator hint = HintGenerator.of(input, answer);
//        hint.getHint();
//        //then
//        assertThat(hint.getStrike()).isEqualTo(3);
//        assertThat(hint.getBall()).isEqualTo(0);
//    }
//
//    @Test
//    @DisplayName("1개만 같고 2개는 위치만 다르면 1스트라이크 2볼")
//    void getHint_strike_and_ball()  {
//        //given
//        List<Integer> answer = 세자리수만들기(1,5,3);
//        List<Integer> input = 세자리수만들기(1,3,5);
//        //when
//        final HintGenerator hint = HintGenerator.of(input, answer);
//        hint.getHint();
//        //then
//        assertThat(hint.getStrike()).isEqualTo(1);
//        assertThat(hint.getBall()).isEqualTo(2);
//    }
//
//    @Test
//    @DisplayName("3개 모두 위치만 다르면 3볼")
//    void getHint_ball() {
//        //given
//        List<Integer> answer = 세자리수만들기(3,5,1);
//        List<Integer> input = 세자리수만들기(1,3,5);
//        //when
//        final HintGenerator hint = HintGenerator.of(input, answer);
//        hint.getHint();
//        //then
//        assertThat(hint.getStrike()).isEqualTo(0);
//        assertThat(hint.getBall()).isEqualTo(3);
//    }
//
//    @Test
//    @DisplayName("해당 되는게 없으면 낫싱")
//    void getHint_Nothing() {
//        //given
//        List<Integer> answer = 세자리수만들기(1,3,5);
//        List<Integer> input = 세자리수만들기(2,4,6);
//        //when
//        final HintGenerator hint = HintGenerator.of(input, answer);
//        hint.getHint();
//        //then
//        assertThat(hint.getStrike()).isEqualTo(0);
//        assertThat(hint.getBall()).isEqualTo(0);
//
//    }
//
//
//
//
//
//
//    private List<Integer> 세자리수만들기(int first, int second, int third) {
//        List<Integer> input = new ArrayList<>();
//        input.add(first);
//        input.add(second);
//        input.add(third);
//        return input;
//    }
//
//}