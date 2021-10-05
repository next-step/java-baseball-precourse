package baseball.view;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import baseball.model.Hint;
import baseball.model.StrikeZone;
import baseball.utils.CollectionUtils;

public final class ResultView {
	private static final String JOINING_SEPARATOR = " ";
	private static final String ALL_STRIKE_OUT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
	private static final String GAME_OVER_MESSAGE = "게임 끝";

	private ResultView() {
	}

	public static void print(Hint hint) {
		System.out.println(getHintString(hint));
		if (hint.isStrikeOut()) {
			System.out.println(ALL_STRIKE_OUT_MESSAGE);
		}
	}

	public static void printGameOverMessage() {
		System.out.println(GAME_OVER_MESSAGE);
	}

	private static String getHintString(Hint hint) {
		List<String> list = new ArrayList<>();
		EnumSet<StrikeZone> strikeZoneSet = EnumSet.of(StrikeZone.STRIKE, StrikeZone.BALL);
		for (StrikeZone strikeZone : strikeZoneSet) {
			addHitStrikeZoneCountString(list, hint, strikeZone);
		}

		if (CollectionUtils.isEmpty(list)) {
			list.add(StrikeZone.NOTHING.getName());
		}
		return joining(list);
	}

	private static void addHitStrikeZoneCountString(List<String> list, Hint hint, StrikeZone strikeZone) {
		int count = hint.getCount(strikeZone);
		boolean isNoneHitCount = count == 0;
		if (isNoneHitCount) {
			return;
		}

		list.add(count + strikeZone.getName());
	}

	private static String joining(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str).append(JOINING_SEPARATOR);
		}
		return sb.length() == 0 ? sb.toString()
			: sb.substring(0, sb.length() - JOINING_SEPARATOR.length());
	}
}
