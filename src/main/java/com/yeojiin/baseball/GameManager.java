package com.yeojiin.baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private final Player player;
    private final Computer computer;

    private static final String REQUEST_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String CORRECT_AND_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public GameManager() {
        player = new Player();
        computer = new Computer();
    }

    public void run() {
        do {
            startGame();
        } while (!finishGame());
    }

    private void startGame() {
        computer.generate();
        do {
            System.out.print(REQUEST_INPUT_NUMBER);
            player.inputNumbers();
            computer.calculateResultCount(player.getNumbers());
            System.out.println(computer.printResult());
        } while ( !computer.isCorrect() );
    }

    private boolean finishGame() {
        System.out.println(CORRECT_AND_END);
        System.out.println(NEW_OR_END);
        return player.inputCommand() == 2;
    }




}
