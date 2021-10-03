package baseball.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @auhor Kim JeongJin <kingroma92@gmail.com>
 * @version 1.0
 * @since 1.0
 * */
public class Computer {
	/**
	 * 초기 컴퓨터가 가질 숫자 저장 List
	 * */
	public List<String> values = new ArrayList<String>() ;
	
	/**
	 * List안의 동일 수 확인을 위한, Ball 체크를 하기위한 Set 
	 * */
	public Set<String> valueSets = new HashSet<String>(); 
	
	public Computer() {
		makeRandomValues();
	}
	
	/**
	 * 랜덤함수를 이용해 3가지의 다른 랜덤 수를 생성한다
	 * */
	private void makeRandomValues() {
		
	}
	
	/**
	 * 입력된 값의 스트라이크 카운트를 반환한다.
	 * 
	 * @param input 사용자가 입력한 3자리 수
	 * @return 스크라이크 카운트 수 
	 * */
	public int getStrikeCount(String input) {
		return 0 ; 
	}
	
	/**
	 * 입력된 값의 볼 카운트를 반환한다
	 * 
	 * @param input 사용자가 입력한 3자리 수
	 * @return 볼 카운트 수 
	 * */
	public int getBallCount(String input) {
		return 0 ;
	}
}
