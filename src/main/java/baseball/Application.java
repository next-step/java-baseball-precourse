package baseball;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {
	
	// 컴퓨터가 사용할 set
	private Set< Integer > randomSet = new LinkedHashSet< Integer >();
	// 사용자가 사용할 set
	private Set< Integer > userSet = new LinkedHashSet< Integer >();
	// 볼 갯수
	private int ballCnt = 0;
	// 스트라이크 갯수
	private int strikeCnt = 0;
	// 컴퓨터가 랜덤으로 생성한 숫자 저장용도 배열
	private int[] randomArr = new int[3];
	// 사용자가 입력한 숫자 저장용도 배열
	private int[] userInputArr = new int[3];
	// 사용자가 입력한 값
	private String userInputNumber = "";
	
	public static void main(String[] args) {

		// TODO 숫자 야구 게임 구현
		/*
		 * 1. 게임시작. ( 랜덤 번호 생성 3개 )
		 * 2. 입력 값 유효성 검증
		 * 3. 입력 값 체크 return boolean true / false , String msg
		 * 4. 게임 종료 및 재시작
		 * */
		Application applcation = new Application();
		applcation.gameStart();
	}

	/**
	 * 시작 지점
	 * <pre>
	 * 1. 무작위 난수생성
	 * 2. client으로 부터 무작위 번호 1~9 입력 받음 ( 유효성 검사 )
	 * 3. 결과 return
	 * </pre>
	 */
	private void gameStart() {
		createComputerNumber( randomArr, randomSet );
		do {
			ballCnt = 0;
			strikeCnt = 0;
			createUserNumber();
		} while ( !compareResult() );
		System.out.println( "게임을새로시작하려면1,종료하려면2를입력하세요" );
		if( "1".equals( Console.readLine() ) ) {
			gameStart();
		} 
		System.exit( -1 );
	}
	
	/**
	 * 중복 제거 된 숫자 생성 처리.
	 */
	private void generateNumber( int[] value, Set< Integer > set ) {
		int i = 0;
		Iterator< Integer > it = set.iterator();
		while( it.hasNext() ) {
			value[i++] = it.next().intValue();
		}
	}
	
	/**
	 * 우아한 형제들에서 제공한 Randoms 클래스의 pickNumberInRange 메서드를 사용하여 무작위 난수 3자리를 생성한다.
	 * <p>
	 * Set 을 사용하여 중복제거를 한다 .
	 * </p>
	 */
	private void createComputerNumber( int[] value, Set< Integer > set ) {
		while( set.size() < 3 ) {
			set.add( Randoms.pickNumberInRange( 1, 9 ) );
		}
		generateNumber( value, set );
		set.clear();
	}

	/**
	 * 사용자가 입력한 번호 생성
	 * <pre>
	 * 입력받은 문자에 대한 유효성검증을 실시하여 유효성 검사에 통과할 경우 int[] 에 저장 한다.
	 * 입력받은 문자가 숫자형태가 아닐경우 exception 발생하여 재귀 처리.
	 * </pre>
	 */
	private void createUserNumber() {
		System.out.print( "숫자를 입력해주세요 : " );
		try {
			userInputNumber = Console.readLine();
		}catch ( NumberFormatException e ) {
			System.out.println("[ERROR] 숫자만 입력해주세요");
			createUserNumber();
		}
		if( !validation( userInputNumber ) ) {
			createUserNumber();
		}
	}

	/**
	 * 유효성 검사
	 * <pre>
	 * 1) 3자리 숫자 , 공백 체크 , 0 체크
	 * 2) 중복 숫자 체크
	 * </pre>
	 */
	private boolean validation( String value ) {
		if( value.length() != 3 || value.indexOf( "0" ) > -1 ) {
			System.out.println( "[ERROR] 0을 제외한 3자리 숫자만 입력하세요" );
			return false;
		}
		if( validationToDuplicate( value ) ) {
			generateNumber( userInputArr, userSet );
			return true;
		}
		return false;
	}

	/**
	 * 유효성 검사
	 */
	private boolean validationToDuplicate( String value ) {
		userSet.clear();
		String[] strArray = value.split("");
		for( String str : strArray ) {
			userSet.add( Integer.parseInt( str ) );
		}
		if( userSet.size() != 3 ) {
			System.out.println("[ERROR] 중복되지 않은 숫자만 입력 가능합니다. ex) 123 ");
			return false;
		}
		return true;
	}
	
	/**
	 * 결과 값 비교
	 */
	private boolean compareResult() {
		for( int i = 0; i < userInputArr.length; i++ ) {
			checkCount( userInputArr[i], i );
		}
		
		System.out.println( getMsg() );
		if( 3 == strikeCnt ) {
			System.out.println( "3개의숫자를모두맞히셨습니다!게임끝" );
			return true;
		}
		return false;
	}
	
	private String getMsg() {
		String msg = MessageTypes.getResultMessage( strikeCnt, ballCnt );
		if( msg.isEmpty() ) {
			msg = MessageTypes.Nothing.getMessage();
		}
		return msg;
	}
	
	/**
	 * strike , ball 체크
	 */
	private void checkCount( int value, int order ) {
		if( randomArr[order] == value ) {
			strikeCnt++;
			return;
		}
		int index = ArrayUtils.indexOf( randomArr , value );
		if( index > -1 ){
			ballCnt++;
		}
	}
	
}
