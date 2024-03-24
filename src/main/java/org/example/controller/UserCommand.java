package org.example.controller;

public enum UserCommand {

    RESTART(1), END(2);

    private final int value;

    UserCommand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
