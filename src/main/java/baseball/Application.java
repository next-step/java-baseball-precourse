package baseball;

import logic.BaseballLogic;
import ui.BaseballUi;

public class Application {
	
	private BaseballLogic bl;
	
	public Application() {
		this.bl = new BaseballLogic(new BaseballUi());
	}
	
    public static void main(String[] args) {
    	Application app = new Application();
    	app.startApp();
    }
    
    private void startApp() {
    	do {
    		bl.genGoals();
        	startGame();
    	} while (bl.checkAppEnd());
    }
    
    private void startGame() {
    	do {
    		bl.inputNumbers();	// 입력
    		bl.makeResult();	// 결과
    		bl.printResult();	// 출력
    	} while (bl.getResults() == null || bl.getResults()[0] != 3);
    }
    
}
