package baseball;

public enum MessageTypes {
	
	Strike	( "%d스트라이크" ),
	Ball	( "%d볼" ),
	Nothing	( "낫싱" ),
	;
	
	private String message;
	
	private MessageTypes( String message ) {
		
		this.message = message;
	}
	

	public String getMessage() {

		return message;
	}
	
	/**
	 * @return the msg
	 */
	public static String getResultMessage( int strikeCnt, int ballCnt ) {
		StringBuffer sb = new StringBuffer();
		if( strikeCnt != 0 ) {
			sb.append( String.format( Strike.message, strikeCnt ) );
		}
		if( ballCnt != 0 ) {
			sb.append( String.format( Ball.message, ballCnt ) );
		}
		return sb.toString();
	}
	
}	
