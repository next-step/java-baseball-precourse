package baseball.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CollectionUtilsTest {
	@Test
	@DisplayName("컬렉션이 null일 경우 true를 반환한다.")
	void isEmpty_should_true_when_null_list() {
		// given

		// when
		boolean isEmpty = CollectionUtils.isEmpty(null);

		// then
		assertThat(isEmpty).isTrue();
	}

	@Test
	@DisplayName("빈 컬렉션일 경우 true를 반환한다.")
	void isEmpty_should_true_when_empty_list() {
		// given
		List<String> emptyList = Collections.emptyList();

		// when
		boolean isEmpty = CollectionUtils.isEmpty(emptyList);

		// then
		assertThat(isEmpty).isTrue();
	}

	@Test
	@DisplayName("컬렉션에 특정 요소가 유니크한 요소인지, 2개 이상의 값이 존재한다면 false")
	void isUniqueElement() {
		// given
		String name = "gmoon";

		assertAll(
			() -> {
				// when
				List<String> list = Collections.unmodifiableList(Arrays.asList(name, "moon", name));

				// then
				assertThat(CollectionUtils.isUniqueElement(list, name))
					.isFalse();

			},
			() -> {
				// when
				List<String> list = Collections.singletonList("moon");

				// then
				assertThat(CollectionUtils.isUniqueElement(list, name))
					.isTrue();
			}
		);
	}

	@Test
	@DisplayName("배열을 리스트로 변환하는지")
	void listOf() {
		// given
		Integer[] integers = {1, 2, 3};

		// when
		List<Integer> actual = CollectionUtils.listOf(integers);

		// then
		assertThat(actual)
			.hasSize(3)
			.containsExactly(1, 2, 3);
	}

	@Test
	@DisplayName("문자열 합치기 테스트")
	void joining() {
		// given
		String separator = ", ";
		List<String> list = Arrays.asList("hello", "java");

		// when
		String actual = CollectionUtils.joining(list, separator);

		// then
		assertThat(actual).isEqualTo("hello, java");
	}
}