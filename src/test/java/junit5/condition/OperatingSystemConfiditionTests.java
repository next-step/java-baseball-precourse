package junit5.condition;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@Disabled
public class OperatingSystemConfiditionTests {

	@Test
	@EnabledOnOs(OS.WINDOWS)
	public void enableOnWindows() {
		System.out.println("Only execute on windows!!");
	}

	@Test
	@EnabledOnOs(OS.MAC)
	public void enableOnMac() {
		System.out.println("Only execute on Mac!!");
	}

	@Test
	@EnabledOnOs(value = {OS.MAC, OS.WINDOWS})
	public void enableOnWindowAndMac() {
		System.out.println("Only execute on Window And Mac!!");
	}

	@Test
	@DisabledOnOs(OS.WINDOWS)
	public void disableOnWindows() {
		System.out.println("Disabled on Window!!");
	}
}
