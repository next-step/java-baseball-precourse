package baseball.game;

import java.util.HashSet;
import java.util.Set;

import baseball.util.CommonUtils;
import baseball.util.Static;

/**
 * @auhor Kim JeongJin <kingroma92@gmail.com>
 * @version 1.0
 * @since 1.0
 * */
public class Validation {
	
	/**
	 * 사용자 입력값의 validation 확인
	 * 
	 * @param input 사용자 입력값
	 * @return 입력값의 validation 참 거짓
	 * */
	public boolean isValid(String input) {
		if ( !defaultValid(input) ) {
			return false ; 
		}
		
		if ( !numberValid(input) ) {
			return false ; 
		}
		
		if ( !sameNumValid(input.split("")) ) {
			return false ; 
		}
		
		return true ;
	}
	
	/**
	 * 숫자 확인 
	 * @param 사용자 입력값
	 * @return 입력값이 있을경우 true | else false  
	 * */
	private boolean defaultValid(String input) {
		if ( CommonUtils.isNullOrEmpty(input) || input.trim().length() != Static.GAME_MAX_LEN ) {
			System.out.println("[ERROR] 입력값이 잘못되었습니다.");
			return false ; 
		}
		
		return true ; 
	}
	
	/**
	 * 숫자 확인 
	 * @param 사용자 입력값
	 * @return 숫자일 경우 true | else false 
	 * */
	private boolean numberValid(String input) {
		if ( !CommonUtils.isNumber(input) ) {
			System.out.println("[ERROR] 숫자가 아닙니다.");
			return false ; 
		}
		
		return true ; 
	}
	
	/**
	 * 동일 숫자 존재 확인 
	 * @param 사용자 입력값
	 * @return 동일한 숫자가 없을 경우 true | else false 
	 * */
	private boolean sameNumValid(String[] input) {
		Set<String> set = new HashSet<String>();
		
		for ( String s : input ) {
			set.add(s);
		}
		
		if ( set.size() != Static.GAME_MAX_LEN ) {
			System.out.println("[ERROR] 같은수가 존재합니다.");
			return false ; 
		}
		
		return true ; 
	}
}
