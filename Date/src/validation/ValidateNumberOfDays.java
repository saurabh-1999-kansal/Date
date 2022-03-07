package validation;

import myExceptions.InvalidInputDaysException;

public class ValidateNumberOfDays {
	

	private ValidateNumberOfDays() {
	}
	
	public static boolean checkNumberOfDaysToBEeAdded(int n) {
		if(n<0) throw new InvalidInputDaysException();
		return true;
	}
}
