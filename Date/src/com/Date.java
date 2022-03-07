package com;

import myExceptions.InvalidMonthException;
import validation.ValidateDate;

public class Date {
	private int day, month, year;
	int d2, m2;

	public Date() {

	}
	public Date(int d, int m, int y) {

		this.day = d;
		this.month = m;
		this.year = y;
	}

	private boolean isLeap(int y) {
//		checkYear(y);
		if (y % 4 == 0 && y % 100 != 0)
			return true;
		if (y % 400 == 0)
			return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return day + "- " + month + " - " + year;
	}

	int offsetDays(int d, int m, int y) {
		int offset = d;

		if (m - 1 == 11)
			offset += 335;
		if (m - 1 == 10)
			offset += 304;
		if (m - 1 == 9)
			offset += 273;
		if (m - 1 == 8)
			offset += 243;
		if (m - 1 == 7)
			offset += 212;
		if (m - 1 == 6)
			offset += 181;
		if (m - 1 == 5)
			offset += 151;
		if (m - 1 == 4)
			offset += 120;
		if (m - 1 == 3)
			offset += 90;
		if (m - 1 == 2)
			offset += 59;
		if (m - 1 == 1)
			offset += 31;

		if (isLeap(y) && m > 2)
			offset += 1;

		return offset;
	}

	// Given a year and days elapsed in it, finds
	// date by storing results in d and m.
	void revoffsetDays(int offset, int y) {
		int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (isLeap(y))
			month[2] = 29;

		int i;
		for (i = 1; i <= 12; i++) {
			if (offset <= month[i])
				break;
			offset = offset - month[i];
		}

		d2 = offset;
		m2 = i;
	}

	// Add x days to the given date.
	public void addDays(int x) {

		int offset1 = offsetDays(day, month, year);
		int remDays = isLeap(year) ? (366 - offset1) : (365 - offset1);

		// y2 is going to store result year and
		// offset2 is going to store offset days
		// in result year.
		int y2, offset2 = 0;
		if (x <= remDays) {
			y2 = year;
			offset2 = offset1 + x;
		}

		else {
			// x may store thousands of days.
			// We find correct year and offset
			// in the year.
			x -= remDays;
			y2 = year + 1;
			int y2days = isLeap(y2) ? 366 : 365;
			while (x >= y2days) {
				x -= y2days;
				y2++;
				y2days = isLeap(y2) ? 366 : 365;
			}
			offset2 = x;
		}
		revoffsetDays(offset2, y2);
		day = d2;
		month = m2;
		year = y2;
	}

}
