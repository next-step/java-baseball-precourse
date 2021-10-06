package baseball.view.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MenuRequest {
	private Menu menu;

	public MenuRequest(final String menu) throws IllegalArgumentException {
		this.menu = Menu.of(menu);
	}

	public Menu getMenu() {
		return menu;
	}

	public enum Menu {
		CONTINUE("1"),
		EXIT("2");

		private final String value;

		Menu(final String value) {
			this.value = value;
		}

		private static Map<String, Menu> valueToMenuMap = new HashMap<>();

		static {
			for (Menu type : Menu.values()) {
				valueToMenuMap.put(type.value, type);
			}
		}

		private static Menu of(final String value) {
			Menu menu = valueToMenuMap.get(value);
			if (Objects.isNull(menu)) {
				throw new IllegalArgumentException("[ERROR] 잘못 입력하셨습니다. 메뉴에 있는 번호만 입력해주세요.");
			}
			return menu;
		}
	}
}
