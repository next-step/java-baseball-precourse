package org.example;

import org.example.support.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberBaseballTest {

    @DisplayName("목표 숫자 생성 테스트")
    @Test
    void targetNumberGenerateTest() {
        // given
        int digitCount = 3;
        int targetNumber = RandomNumberGenerator.generate(1, 9, digitCount);

        // when & then
        assertThat(String.valueOf(targetNumber)).hasSize(digitCount);
        assertThat(String.valueOf(targetNumber)).doesNotContain("0");
    }
}
