package org.example.model;

public enum GameStatus {

    START("숫자를 입력해주세요 : "),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 끝\n게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    GameStatus(String message) {
        this.message = message;
    }

    public boolean isStart() {
        return this == START;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
