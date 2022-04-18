package config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputPolicyTest {
    @Test
    void defaultPolicy(){
        Assertions.assertThat(InputPolicy.defaultPolicy("abcd", 3)).isFalse();
        Assertions.assertThat(InputPolicy.defaultPolicy("abc", 3)).isFalse();
        Assertions.assertThat(InputPolicy.defaultPolicy("1234", 3)).isFalse();

        Assertions.assertThat(InputPolicy.defaultPolicy("123", 3)).isTrue();
    }

    @Test
    void addPolicyInMenu(){
        Assertions.assertThat(InputPolicy.addPolicyInMenu("abc")).isFalse();
        Assertions.assertThat(InputPolicy.addPolicyInMenu("qweabc")).isFalse();
        Assertions.assertThat(InputPolicy.addPolicyInMenu("!@GW!#R")).isFalse();
        Assertions.assertThat(InputPolicy.addPolicyInMenu("4")).isFalse();
        Assertions.assertThat(InputPolicy.addPolicyInMenu("1")).isTrue();
    }
}