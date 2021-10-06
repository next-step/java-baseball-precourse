package baseball.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    InputValidator test = new InputValidator();

    @Test
    @DisplayName("통합테스트")
    void 테스트(){
        //given
        String tc_1 = "321";
        String tc_2 = "13 2";
        String tc_3 = "456";
        String tc_4 = "893";
        String tc_5 = "t32";
        String tc_6 = "a2b";

        //then
        Assertions.assertEquals(true, test.checkPipeLine(tc_1));
        Assertions.assertEquals(false, test.checkPipeLine(tc_2));
        Assertions.assertEquals(true, test.checkPipeLine(tc_3));
        Assertions.assertEquals(true, test.checkPipeLine(tc_4));
        Assertions.assertEquals(false, test.checkPipeLine(tc_5));
        Assertions.assertEquals(false, test.checkPipeLine(tc_6));
    }

//    @Test
//    @DisplayName("숫자형태인지 확인, private 선언하기 전 확인")
//    void 숫자확인(){
//        //given
//        String tc_1 = "321";
//        String tc_2 = "123";
//        String tc_3 = "456";
//        String tc_4 = "893";
//        String tc_5 = "t32";
//        String tc_6 = "a2b";
//
//        //then
//        Assertions.assertEquals(true, test.isNumeric(tc_1));
//        Assertions.assertEquals(true, test.isNumeric(tc_2));
//        Assertions.assertEquals(true, test.isNumeric(tc_3));
//        Assertions.assertEquals(true, test.isNumeric(tc_4));
//        Assertions.assertEquals(false, test.isNumeric(tc_5));
//        Assertions.assertEquals(false, test.isNumeric(tc_6));
//    }
//
//    @Test
//    @DisplayName("공백 존재여부 확인, private 선언하기 전 확인")
//    void 공백확인(){
//        //given
//        String tc_1 = "123";
//        String tc_2 = "345";
//        String tc_3 = "629";
//        String tc_4 = "283";
//        String tc_5 = "13 2";
//        String tc_6 = "5 23";
//        //then
//        Assertions.assertEquals(true, test.checkSpace(tc_1));
//        Assertions.assertEquals(true, test.checkSpace(tc_2));
//        Assertions.assertEquals(true, test.checkSpace(tc_3));
//        Assertions.assertEquals(true, test.checkSpace(tc_4));
//        Assertions.assertEquals(false, test.checkSpace(tc_5));
//        Assertions.assertEquals(false, test.checkSpace(tc_6));
//    }
//
//    @Test
//    @DisplayName("길이가 3이 맞는지 확인, private 선언하기 전 확인")
//    void 길이확인(){
//        //given
//        String tc_1 = "123";
//        String tc_2 = "345";
//        String tc_3 = "629";
//        String tc_4 = "283";
//        String tc_5 = "1132";
//        String tc_6 = "23";
//        //then
//        Assertions.assertEquals(true, test.checkLength(tc_1));
//        Assertions.assertEquals(true, test.checkLength(tc_2));
//        Assertions.assertEquals(true, test.checkLength(tc_3));
//        Assertions.assertEquals(true, test.checkLength(tc_4));
//        Assertions.assertEquals(false, test.checkLength(tc_5));
//        Assertions.assertEquals(false, test.checkLength(tc_6));
//    }
//
//    @Test
//    @DisplayName("음수인지 확인, private 선언하기 전 확인")
//    void 음수확인(){
//        //given
//        String tc_1 = "123";
//        String tc_2 = "345";
//        String tc_3 = "629";
//        String tc_4 = "283";
//        String tc_5 = "-11";
//        String tc_6 = "-134";
//        //then
//        Assertions.assertEquals(true, test.checkNegative(tc_1));
//        Assertions.assertEquals(true, test.checkNegative(tc_2));
//        Assertions.assertEquals(true, test.checkNegative(tc_3));
//        Assertions.assertEquals(true, test.checkNegative(tc_4));
//        Assertions.assertEquals(false, test.checkNegative(tc_5));
//        Assertions.assertEquals(false, test.checkNegative(tc_6));
//    }
//
//    @Test
//    @DisplayName("중복된 숫자 존재 확인, private 선언하기 전 확인")
//    void 중복확인(){
//        //given
//        String tc_1 = "123";
//        String tc_2 = "323";
//        String tc_3 = "629";
//        String tc_4 = "283";
//        String tc_5 = "332";
//        String tc_6 = "144";
//        //then
//        Assertions.assertEquals(true, test.checkDuplication(tc_1));
//        Assertions.assertEquals(false, test.checkDuplication(tc_2));
//        Assertions.assertEquals(true, test.checkDuplication(tc_3));
//        Assertions.assertEquals(true, test.checkDuplication(tc_4));
//        Assertions.assertEquals(false, test.checkDuplication(tc_5));
//        Assertions.assertEquals(false, test.checkDuplication(tc_6));
//    }

}
