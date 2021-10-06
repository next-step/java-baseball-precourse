package Study;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.ApplicationTest;

public class StringTest {
	
	@DisplayName("배열에 재대로 담겼는지 확인합니다.")
	@Test
	void splitedTest() {
			String[] splitedValue = "1,2".split(",");
			assertThat(splitedValue).containsExactly("1","2");
			
			String[] splitedSoloValue = "1".split(",");
			assertThat(splitedSoloValue).containsExactly("1");
		}
	
	@DisplayName("assertJ를 활용한 배열검증입니다.")
	@Disabled
	@Test
	void assertjContainTest() {
		char atCharValue = "abc".charAt(3);
		
//		assertThatThrownBy(){
//			
//		}
	}
	

}
