package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballGameTest {

	private final String THREE_STRIKES = " : 3 : 0";
	private final String TWO_STRIKES_NO_BALL = " : 2 : 0";
	private final String ONE_STRIKE_NO_BALL = " : 1 : 0";
	private final String ONE_STRIKE_ONE_BALL = " : 1 : 1";
	private final String ONE_STRIKE_TWO_BALLS = " : 1 : 2";
	private final String NO_STRIKE_THREE_BALLS = " : 0 : 3";
	private final String NO_STRIKE_TWO_BALLS = " : 0 : 2";
	private final String NO_STRIKE_ONE_BALL = " : 0 : 1";
	private final String NO_STRIKE_NO_BALL = " : 0 : 0";

	@ParameterizedTest
	@CsvSource(value = {
		/* 3 strikes cases */
		"123 : 123" + THREE_STRIKES,
		"321 : 321" + THREE_STRIKES,
		"364 : 364" + THREE_STRIKES,

		/* 2 strikes 1 ball cases */
		/* no cases */

		/* 2 strikes NO ball cases*/
		"123 : 124" + TWO_STRIKES_NO_BALL,        // SSN(strike, strike, nothing)
		"523 : 593" + TWO_STRIKES_NO_BALL,        // SNS
		"951 : 958" + TWO_STRIKES_NO_BALL,        // NSS

		/* 1 strike NO ball cases */
		"123 : 198" + ONE_STRIKE_NO_BALL,        // SNN
		"951 : 852" + ONE_STRIKE_NO_BALL,        // NSN
		"673 : 953" + ONE_STRIKE_NO_BALL,        // NNS

		/* 1 strike 1 ball cases */
		"123 : 138" + ONE_STRIKE_ONE_BALL,        // SBN
		"673 : 657" + ONE_STRIKE_ONE_BALL,        // SNB
		"673 : 378" + ONE_STRIKE_ONE_BALL,        // BSN
		"673 : 793" + ONE_STRIKE_ONE_BALL,        // BNS
		"951 : 859" + ONE_STRIKE_ONE_BALL,        // NSB
		"951 : 291" + ONE_STRIKE_ONE_BALL,        // NBS

		/* 1 strike 2 balls cases */
		"123 : 132" + ONE_STRIKE_TWO_BALLS,        // SBB
		"632 : 236" + ONE_STRIKE_TWO_BALLS,        // BSB
		"915 : 195" + ONE_STRIKE_TWO_BALLS,        // BBS

		/* NO strike 3 balls cases */
		"123 : 312" + NO_STRIKE_THREE_BALLS,        // BBB
		"632 : 263" + NO_STRIKE_THREE_BALLS,        // BBB
		"915 : 591" + NO_STRIKE_THREE_BALLS,        // BBB

		/* NO strike 2 balls cases */
		"123 : 214" + NO_STRIKE_TWO_BALLS,        // BBN
		"632 : 246" + NO_STRIKE_TWO_BALLS,        // BNB
		"915 : 251" + NO_STRIKE_TWO_BALLS,        // NBB

		/* NO strike 1 ball cases */
		"123 : 394" + NO_STRIKE_ONE_BALL,        // BNN
		"632 : 298" + NO_STRIKE_ONE_BALL,        // NBN
		"915 : 176" + NO_STRIKE_ONE_BALL,        // NNB

		/* NO strike NO ball cases */
		"123 : 954" + NO_STRIKE_NO_BALL,        // NNN
		"632 : 189" + NO_STRIKE_NO_BALL,        // NNN
		"915 : 243" + NO_STRIKE_NO_BALL,        // NNN
	}
		, delimiterString = " : ")
	void test_all_possible_cases(String answer, String input, int expectedStrikeCount, int expectedBallCount) {
		//TODO parameter 부분 각 결과별 answer, input 생성기 구현하여 간소화 가능
		BaseballGame game = new BaseballGame(answer);
		BaseballGameScoreBoard board = game.deal(input);
		assertThat(board.getStrikeCount()).isEqualTo(expectedStrikeCount);
		assertThat(board.getBallCount()).isEqualTo(expectedBallCount);
	}
}
