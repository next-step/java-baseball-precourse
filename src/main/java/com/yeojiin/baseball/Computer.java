package com.yeojiin.baseball;

public class Computer {
    Number number;

    // 랜덤 숫자 생성
    public void generate() {
        number = Number.generateRandomNumbers();
    }

    public Number getNumber() {
        return number;
    }
}
