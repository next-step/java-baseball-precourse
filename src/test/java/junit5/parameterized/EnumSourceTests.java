package junit5.parameterized;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

import junit5.domain.Animal;

public class EnumSourceTests {

	@ParameterizedTest
	@EnumSource(value = Animal.class)
	public void enumSourceTest(Animal animal) {
		assertNotNull(animal);
	}

	@ParameterizedTest
	@EnumSource(value = Animal.class, names = { "DOG", "CAT" })
	public void enumSourceWithNames(Animal animal) {
		assertNotNull(animal);
	}

	@ParameterizedTest
	@EnumSource(value = Animal.class, mode = Mode.EXCLUDE, names = { "DOG", "CAT" })
	public void enumSourceWithExcludeMode(Animal animal) {
		assertNotNull(animal);
	}

	@ParameterizedTest
	@EnumSource(value = Animal.class, mode = Mode.MATCH_ALL, names = "^(C|L).+$")
	public void enumSourceWithMatchAllMode(Animal animal) {
		assertNotNull(animal);
	}

}
