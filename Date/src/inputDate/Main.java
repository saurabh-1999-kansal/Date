package inputDate;

import java.util.Scanner;

import com.Date;

import validation.ValidateDate;
import validation.ValidateNumberOfDays;

public class Main {
	public static void main(String[] args) {

//		Date d=new Date(28,2,5);
//		System.out.println(d);
//		System.out.println(ValidateNumberOfDays.tester.checkNumberOfDaysToBEeAdded(28));

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the date in dd-MM-yyyy format ");
		String date = scn.next();
		int noOfDays = scn.nextInt();
		int d = Integer.parseInt(date.split("-")[0]);
		int m = Integer.parseInt(date.split("-")[1]);
		int y = Integer.parseInt(date.split("-")[2]);
		ValidateNumberOfDays.checkNumberOfDaysToBEeAdded(noOfDays);
		ValidateDate.ValidationDate(d, m, y);
		Date dateDate = new Date(d, m, y);
		dateDate.addDays(noOfDays);
        System.out.println(dateDate);
	}
}
