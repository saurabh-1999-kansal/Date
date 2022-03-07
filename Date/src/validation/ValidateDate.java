package validation;

import myExceptions.InvalidDayException;
import myExceptions.InvalidMonthException;
import myExceptions.InvalidYearException;

public class ValidateDate {
	

	public static boolean ValidationDate(int d,int m,int y) {
     
		return checkDay(d,m,y) && checkYear(y);
		
	}

	private static boolean isLeap(int y) {
		checkYear(y);
		if (y % 4 == 0 && y % 100 != 0)
			return true;
		if (y % 400 == 0)
			return true;
		return false;
	}

	private static boolean checkMonth(int m) {
		if (m <= 0 || m > 12) {
			throw new InvalidMonthException();
		}
		return true;
	}

	private static boolean checkYear(int y) {
		if (y <= 0) {
			throw new InvalidYearException();
		}
		return true;
	}

	public static int noOfDaysInMonth(int d, int m, int y) {

		checkMonth(m);
        
		if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
			return 31;

		if (m == 2) {
			return isLeap(y) ? 29 : 28;

		}
		return 30;
	}

	private static boolean checkDay(int d,int m,int y) {
		int numOfDays = noOfDaysInMonth(d, m, y);
		if (d <= 0 || d > numOfDays) {
			throw new InvalidDayException();
		}
		return true;
	}



}
