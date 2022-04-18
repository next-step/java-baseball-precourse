package baseball.contoller;

import baseball.model.*;
import baseball.view.AnswerWriter;
import baseball.view.InquireReader;

public class BaseballGame {
    private AnswerRandomNumberGenerator answerRandomNumberGenerator;
    private AnswerPlayer answerPlayer;
    private InquirePlayer inquirePlayer;
    private RequestHint requestHint;
    private ResponseHint responseHint;

    public BaseballGame() {
        answerRandomNumberGenerator = new AnswerRandomNumberGenerator();
        requestHint = new RequestHint();
        responseHint = new ResponseHint();
        answerPlayer = new AnswerPlayer();
        inquirePlayer = new InquirePlayer();
    }

    public void start() {
        answerPlayer.thinkGoodAnswerGameNumbers(answerRandomNumberGenerator);

        while (!responseHint.isGameEndFlag()) {
            inquirePlayer.thinkGoodInquireGameNumbers(InquireReader.inquire());
            requestHint = inquirePlayer.inquireThinkedGameNumber();
            responseHint = answerPlayer.thinkAnswerRoundHintOrResult(requestHint);
            AnswerWriter.answer(responseHint);
        }
    }
}
