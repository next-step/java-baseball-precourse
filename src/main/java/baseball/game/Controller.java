package baseball.game;

import nextstep.utils.Console;

/**
 * @auhor Kim JeongJin <kingroma92@gmail.com>
 * @version 1.0
 * @since 1.0
 * */
public class Controller {
	public Controller() { } // 생성자 
	
	/**
	 * Application에서 시작하는 메소드
	 * */
	public void start() {
		boolean isFinish = false ; 
		
		while ( !isFinish ) {
			isFinish = ask() ;
		}
		
		System.out.println("게임 끝");
	}
	
	private boolean ask() {
		String input = Console.readLine() ;
		
		if ( !inputValid(input) ) {
			return false ; 
		}
		
		return result(input) ; 
	}
	
	/**
	 * 입력값의 validation 확인
	 * 
	 * @param input 사용자 입력값
	 * @return 입력값 validation의 참 거짓
	 * */
	private boolean inputValid(String input) {
		return true ; 
	}
	
	/**
	 * 야구 게임 결과 도출 로직
	 * 
	 * @param input 사용자 입력값
	 * @return 야구게임 진행 여부
	 * */
	private boolean result(String input) {
		return true ;
	}
}
