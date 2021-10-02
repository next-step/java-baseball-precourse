package junit5.service;

public class StringHelper {

	public String reverse(String input) {
		if (input == null)
			return null;

		if (input.isEmpty())
			return "";

		StringBuffer sb = new StringBuffer(input);
		return sb.reverse().toString();
	}

}
