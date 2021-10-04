package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RandomNumberTest {
  List<int[]> duplicateNumbers;
  int BASE_BALL_SIZE = 3;

  @BeforeAll
  void setUp() {
    duplicateNumbers = new ArrayList<>();
    duplicateNumbers.add(new int[] {3, 3, 5});
    duplicateNumbers.add(new int[] {6, 1, 1});
    duplicateNumbers.add(new int[] {4, 2, 4});
    duplicateNumbers.add(new int[] {7, 7, 7});
    duplicateNumbers.add(new int[] {8, 8, 9});
  }

  @Test
  @Order(1)
  @DisplayName("중복된 수가 있는지 체크하는 로직을 검증한다.")
  void checkDuplicateNumber() {
    for (int[] numbers : duplicateNumbers) {
      // given
      HashSet<Integer> hashSet = new HashSet<>();
      boolean isDuplicate = false;
      for (int number : numbers) {
        hashSet.add(number);
      }

      // when
      if (hashSet.size() != BASE_BALL_SIZE) {
        isDuplicate = true;
      }

      // then
      assertThat(isDuplicate).isTrue();
    }
  }

  @Test
  @Order(2)
  @DisplayName("RandomNumber 객체 생성 시 유효한 랜덤수가 생성되었는지 테스트한다.")
  public void makeRandomNumber() {
    // given
    RandomNumber randomNumber = RandomNumber.makeRandomNumber();
    HashSet<Integer> checkHashSet = new HashSet<>();

    // when
    for (int number : randomNumber.getNumbers()) {
      checkHashSet.add(number);
    }

    // then
    for (int i = 0; i < Short.MAX_VALUE; i++) {
      assertThat(checkHashSet.size()).isEqualTo(RandomNumber.SIZE);
    }
  }
}