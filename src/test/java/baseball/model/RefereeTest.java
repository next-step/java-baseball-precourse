package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RefereeTest {
    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;
    private Referee referee;

    @BeforeEach
    void setUp() {
        computerNumbers = Arrays.asList(1, 4, 7);
        playerNumbers = new ArrayList<>();
        referee = new Referee();
    }
    @DisplayName("스트라이크 개수 조회")
    @ParameterizedTest
    @CsvSource(value = {"123:1", "234:0", "345:1", "456:0", "567:1", "149:2", "147:3"}, delimiter = ':')
    void 스트라이크_개수_조회(String number, String sCount) {
        for(char c : number.toCharArray()){
            playerNumbers.add(c - '0');
        }

        referee.init(computerNumbers, playerNumbers);
        referee.judge();

        assertThat(referee.getSCount()).isEqualTo(Integer.parseInt(sCount));
    }

    @DisplayName("볼 개수 조회")
    @ParameterizedTest
    @CsvSource(value = {"123:0", "234:1", "345:0", "456:1", "567:0", "471:3", "714:3"}, delimiter = ':')
    void 볼_개수_조회(String number, String bCount) {
        for(char c : number.toCharArray()){
            playerNumbers.add(c - '0');
        }

        referee.init(computerNumbers, playerNumbers);
        referee.judge();

        assertThat(referee.getBCount()).isEqualTo(Integer.parseInt(bCount));
    }
}
