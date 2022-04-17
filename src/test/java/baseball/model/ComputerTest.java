package baseball.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ComputerTest {

    @Test
    void Test_Computer_Generate_Valid_Three_Numbers() {
//        Computer computer = new Computer();
//        List<Integer> numbers = computer.generateThreeNumbers();
//        for (Integer number : numbers) {
//
//        }
        String[] inputs = {"1", "2", "가"};
        for (String string : inputs) {
            try {
                Integer.parseInt(string);
            } catch (Exception e) {
                System.out.println(string);
                System.out.println(e);
            }
        }
    }
    Computer computer;
    @BeforeEach
    void BeforeAll() {
        computer = new Computer();
    }

    @RepeatedTest(10)
    void Test_RandomNumbers() {
        int number = computer.getRandomNumbers();
        assertTrue(1 <= number && number <= 45);
    }
}