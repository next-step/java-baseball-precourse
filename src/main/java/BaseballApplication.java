public class BaseballApplication {
	public static void main(String[] args) {
		Baseball model = new Baseball();
		BaseballView view = new BaseballView();
		BaseballController controller = new BaseballController(model, view);

		controller.run();
	}
}
