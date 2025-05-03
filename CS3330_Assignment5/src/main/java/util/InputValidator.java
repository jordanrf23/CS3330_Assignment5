package util;

public class InputValidator {
	
	public static boolean isNullOrEmpty(String input) {
		return input == null || input.trim().isEmpty();
	}
	
	public static boolean isValidAge(int age) {
		return age >0;
	}

}
