package baseball.controller;

import baseball.generator.HintGenerator;
import baseball.generator.InputGenerator;
import baseball.generator.NumberGenerator;
import baseball.message.Message;
import baseball.message.Number;
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
     * 플레이어에게 3자리 숫자를 입력받고 맞출 때 까지 힌트 제공
     * @param answer
     */
    private void startGame(List<Integer> answer) {
        System.out.println(answer);
        while(true){
            final List<Integer> input = getInputNumber();
            if (answerCheck(answer, input)){
                break;
            }
        }
    }

    /**
     * 플레이어에게 3자리 숫자를 입력받고 검증한다음
     * 검증에 성공하면
     * 입력받은 문자열을 정수 리스트로 반환
     * @return
     */
    private List<Integer> getInputNumber() {
        while (true) {
            final String input = InputGenerator.inputThreeDigits();
            if (!validateInputNumber(input)) {
                continue;
            }
            return InputGenerator.convertToIntegerList(input);
        }
    }

    /**
     * 플레이어가 입력한 3자리 숫자가 정답인지 체크
     * @param answer
     * @param input
     * @return
     */
    private boolean answerCheck(List<Integer> answer, List<Integer> input) {
        final HintGenerator hint = getHint(input, answer);
        return hint.printHint();
    }

    /**
     * 플레이어가 3자리 숫자를 입력하면 3자리 숫자가 맞는지 검증 후
     * 검증에 실패하면 다시 입력하라고 안내 후
     * 검증에 성공했을 시 문자열로 받은 3자리 숫자를 정수 리스트로 변환해서 반환
     * @return
     */
    private boolean validateInputNumber(String input) {
        try {
            InputValidator.validateInput(input);
            return true;
        } catch (Exception e) {
            Message.Print(e.getMessage());
            return false;
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
     * 플레이어가 입력한 3자리수가 정답인지 체크
     * @param input
     * @param answer
     * @return
     */
    private HintGenerator getHint(List<Integer> input, List<Integer> answer) {
        return HintGenerator.getHint(input, answer);
    }

    /**
     * 1를 입력하면 게임 새로 시작, 2를 입력하면 게임 종료
     * @return
     */
    private boolean endGame() {
        while (true) {
            Message.Print(TextMessage.CONTINUE_OR_END);
            final String kb = Console.readLine();
            if (Number.RESTART_NUMBER.equals(kb)) {
                return false;
            }
            if (Number.END_NUMBER.equals(kb)) {
                return true;
            }
        }
    }



}