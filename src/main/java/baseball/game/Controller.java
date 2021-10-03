package baseball.game;

import baseball.util.Static;
import nextstep.utils.Console;

/**
 * @auhor Kim JeongJin <kingroma92@gmail.com>
 * @version 1.0
 * @since 1.0
 * */
public class Controller {
	private Computer computer = new Computer();
	
	private Validation validation = new Validation();
	
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
		return validation.isValid(input) ; 
	}
	
	/**
	 * 야구 게임 결과 도출 로직
	 * 
	 * @param input 사용자 입력값
	 * @return 야구게임 진행 여부
	 * */
	private boolean result(String input) {
		int strikeCount = computer.getStrikeCount(input);
		int ballCount = computer.getBallCount(input);
		
		printResult(strikeCount,ballCount);
		
		if ( strikeCount == Static.GAME_MAX_LEN ) {
			return true ; 
		}
		
		return false ;
	}
	
	/**
	 * 야구 게임 결과 표시
	 * 
	 * @param strikeCount 스트라이크 카운트
	 * @param ballCount 볼 카운트 
	 * */
	private void printResult(int strikeCount , int ballCount) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(getNothingPrint(strikeCount, ballCount));
		
		sb.append(getStrikePrint(strikeCount));
		
		if ( strikeCount > 0 ) {
			sb.append(" ");
		}
		
		sb.append(getBallPrint(ballCount));
			
		System.out.println(sb.toString());
	}
	
	private String getNothingPrint(int strikeCount, int ballCount) {
		if ( strikeCount == 0 && ballCount == 0 ) {
			return "낫싱";
		} 
		
		return "";
	}
	
	private String getStrikePrint(int strikeCount) {
		if ( strikeCount > 0 ) {
			return strikeCount + "스트라이크";
		} 
		
		return "";
	}
	
	private String getBallPrint(int ballCount) {
		if ( ballCount > 0 ) {
			return ballCount + "볼";
		} 
		
		return "";
	}
	
	
	
}
