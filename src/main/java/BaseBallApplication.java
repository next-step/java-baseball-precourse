import application.ScoreCalculator;
import domain.AnswerGenerator;
import infrastructure.CollectionAnswerGenerator;
import presentation.BaseBallController;
import presentation.InputReceiver;

public class BaseBallApplication {
	public static void main(String[] args) {
		InputReceiver inputReceiver = new InputReceiver();
		ScoreCalculator scoreCalculator = new ScoreCalculator();
		AnswerGenerator answerGenerator = new CollectionAnswerGenerator();
		BaseBallController baseBallController =
			new BaseBallController(inputReceiver, scoreCalculator, answerGenerator);

		do {
			baseBallController.start();

		} while (baseBallController.isRestart());
	}
}
