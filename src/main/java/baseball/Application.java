package baseball;

import baseball.view.GameViewer;

public class Application {
	public static void main(String[] args) {
		// TODO 숫자 야구 게임 구현
		GameViewer viewer = GameViewer.getInstance();
		viewer.start();
	}
}
