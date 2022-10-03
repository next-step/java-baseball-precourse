package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import baseball.service.BaseballService;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayBaseTest {

    private final PlayBase base = new PlayBase();

    @BeforeEach
    void init(){
        base.initializeInning();
    }

    @Test
    @DisplayName("getPickNumber:[success]")
    void getPickNumber() {
        //when
        int[] numberArr = base.getNumberArr();
        Set<Integer> numberJar = base.getNumberJar();
        //then
        assertThat(numberJar).hasSize(3);
        for (int i = 0; i < 3; i++) {
            assertThat(numberArr[i]).isBetween(1,9);
            assertThat(numberJar.add(numberArr[i])).isFalse();
        }
    }

    @Test
    @DisplayName("getCountsTest (3 스트라이크):[success]")
    void getCounts_3StrikeTest(){
        //given
        for (int i = 0; i < 3; i++) {
            base.addStrikeCounts();
        }
        //when
        String counts = base.getCounts();
        //then
        assertThat(counts).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("getCountsTest (3 볼):[success]")
    void getCounts_3BallTest(){
        //given
        for (int i = 0; i < 3; i++) {
            base.addBallCounts();
        }
        //when
        String counts = base.getCounts();
        //then
        assertThat(counts).isEqualTo("3볼");
    }

    @Test
    @DisplayName("getCountsTest (1볼, 1스트라이크):[success]")
    void getCounts_1Ball1StrikeTest(){
        //given
        base.addStrikeCounts();
        base.addBallCounts();
        //when
        String counts = base.getCounts();
        //then
        assertThat(counts).isEqualTo("1볼 1스트라이크");
    }

}