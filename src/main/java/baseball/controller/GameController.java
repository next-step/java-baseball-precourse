package baseball.controller;

import baseball.generator.HintGenerator;
import baseball.generator.InputGenerator;
import baseball.generator.NumberGenerator;
import baseball.message.error.ErrorCode;
import baseball.message.text.TextMessage;
import baseball.validator.InputValidator;
import nextstep.utils.Console;

import java.util.List;

public class GameController {

    /**
     * 게임을 시작하고 난 후 문제를 맞추면 게임을 계속 할지 중단할지 체크
     */
    public void baseballGame() {
        do {
          startGame(gameSetup());
        } while (!endGame());
    }

    /**
     * 플레이어에게 3자리 숫자를 입력받고 맞출 때 까지 정답을 체크
     * @param answer
     */
    private void startGame(List<Integer> answer) {
        while (true) {

            final List<Integer> inputList = getInputNumber();
            if (answerCheck(inputList, answer)) {
                break;
            }
        }
    }

    /**
     * 플레이어가 3자리 숫자를 입력하면 3자리 숫자가 맞는지 검증 후
     * 검증에 실패하면 다시 입력하라고 안내 후
     * 검증에 성공했을 시 문자열로 받은 3자리 숫자를 정수 리스트로 변환해서 반환
     * @return
     */
    private List<Integer> getInputNumber() {
        while (true) {
            final String input = inputNumber();
            if (isInputError(input)) {
                System.out.println(input);
                continue;
            }
            return InputGenerator.convertToIntegerList(input);
        }
    }

    /**
     * 컴퓨터가 랜덤으로 3자리 숫자 만들기
     * @return
     */
    private List<Integer> gameSetup() {
        return NumberGenerator.makeThreeDigits();
    }

    /**
     * 플레이어가 입력한 3자리수가 에러인지 체크
     * @param input
     * @return
     */
    private boolean isInputError(String input) {
        return input.startsWith(ErrorCode.ERROR);
    }

    /**
     * 플레이어가 입력한 3자리수가 정답인지 체크
     * @param input
     * @param answer
     * @return
     */
    private boolean answerCheck(List<Integer> input, List<Integer> answer) {
        return HintGenerator.of(input, answer).getHint();
    }

    /**
     * 플레이어가 3자리수를 입력한 후 검증하기
     * @return
     */
    private String inputNumber() {
        return InputValidator.validateInput(InputGenerator.inputThreeDigits());
    }

    /**
     * 1를 입력하면 게임 새로 시작, 2를 입력하면 게임 종료
     * @return
     */
    private boolean endGame() {
        while (true) {
            System.out.print(TextMessage.CONTINUE_OR_END);
            final String kb = Console.readLine();
            if ("1".equals(kb)) {
                return false;
            }
            if ("2".equals(kb)) {
                return true;
            }
        }
    }



}