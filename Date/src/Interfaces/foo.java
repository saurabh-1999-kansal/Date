package Interfaces;

import myExceptions.InvalidDayException;
import myExceptions.InvalidMonthException;
import myExceptions.InvalidYearException;

public abstract class foo {
	public  boolean isLeap(int y) {
		checkYear(y);
		if (y % 4 == 0 && y % 100 != 0)
			return true;
		if (y % 400 == 0)
			return true;
		return false;
	}

	public  boolean checkMonth(int m) {
		if (m <= 0 || m > 12) {
			throw new InvalidMonthException();
		}
		return true;
	}

	public boolean checkYear(int y) {
		if (y <= 0) {
			throw new InvalidYearException();
		}
		return true;
	}

	public  int noOfDaysInMonth(int d, int m, int y) {

		checkMonth(m);
        
		if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
			return 31;

		if (m == 2) {
			return isLeap(y) ? 29 : 28;

		}
		return 30;
	}

	public  boolean checkDay(int d,int m,int y) {
		int numOfDays = noOfDaysInMonth(d, m, y);
		if (d <= 0 || d > numOfDays) {
			throw new InvalidDayException();
		}
		return true;
	}
}
