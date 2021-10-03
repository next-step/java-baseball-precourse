package baseball.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.util.Static;
import nextstep.utils.Randoms;

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
		values = new ArrayList<String>();
		
		for ( int i = 0 ; i < Static.GAME_MAX_LEN ; i ++ ) {
			String value = makeOneRandomValue();
			valueSets.add(value);
			values.add(value);
		}
	}
	
	private String makeOneRandomValue() {
		String value = null;
		
		while ( value == null ) {
			value = getOneDiffRandomValue();
		}
		
		return value;
	}
	
	private String getOneDiffRandomValue() {
		String value = String.valueOf(Randoms.pickNumberInRange(1, 9)) ;
		
		if ( valueSets.contains(value) ) {
			value = null ; 
		}
		
		return value ;
	}
	
	/**
	 * 입력된 값의 스트라이크 카운트를 반환한다.
	 * 
	 * @param input 사용자가 입력한 3자리 수
	 * @return 스크라이크 카운트 수 
	 * */
	public int getStrikeCount(String input) {
		int count = 0 ;
		String[] split = input.split("");
		
		for ( int i = 0 ; i < Static.GAME_MAX_LEN ; i ++ ) {
			count += isStrike(values.get(i),split[i]);
		}
		
		return count ; 
	}
	
	private int isStrike(String input1, String input2) {
		if ( input1.equals(input2) ) {
			return 1 ;
		}
		
		return 0 ;
	} 
	
	/**
	 * 입력된 값의 볼 카운트를 반환한다
	 * 
	 * @param input 사용자가 입력한 3자리 수
	 * @return 볼 카운트 수 
	 * */
	public int getBallCount(String input) {
		int count = 0 ; 
		
		String[] split = input.split("");
		
		for ( int i = 0 ; i < Static.GAME_MAX_LEN ; i ++ ) {
			count += isBall(split[i], i);
		}
			
		return count ; 
	}
	
	private int isBall(String input, int index) {
		if ( !values.get(index).equals(input) && valueSets.contains(input) ) {
			return 1 ; 
		}
		
		return 0 ;
	}
}
