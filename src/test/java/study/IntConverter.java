package study;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class IntConverter extends SimpleArgumentConverter {
	@Override
	protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
		if (isBoolean(source.toString())) {
			return Integer.MIN_VALUE;
		}
		return Integer.parseInt(source.toString());
	}

	private boolean isBoolean(String source) {
		if (source.indexOf("true") > -1) {
			return true;
		}

		if (source.indexOf("false") > -1) {
			return true;
		}

		return false;
	}
}
