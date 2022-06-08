package com.atm;

import java.util.Scanner;

public class ATMAPP {

	public static void deposit(int[] arr, Scanner sc) {

		System.out.println("Enter Amount to Deposit ");
		
		System.out.println("Enter No. of 2000 Notes: ");
		int Note2000 = sc.nextInt();
		System.out.println("Enter No. of 500 Notes:");
		int Note500 = sc.nextInt();
		System.out.println("Enter No. of 200 Notes:");
		int Note200 = sc.nextInt();
		System.out.println("Enter No. of 100 Notes:");
		int Note100 = sc.nextInt();

		if (Note2000 < 0 || Note500 < 0 || Note200 < 0 || Note100 < 0) {
			System.out.println("Incorrect Deposit Amount");
		}

		if (Note2000 == 0 && Note500 == 0 && Note200 == 0 && Note100 < 0) {
			System.out.println("Deposit amount cannot be zero");
		}

		arr[0] = arr[0] + Note2000;
		arr[1] = arr[1] + Note500;
		arr[2] = arr[2] + Note200;
		arr[3] = arr[3] + Note100;

		System.out.println("Balance: 2000s=" + arr[0] + ",500s=" + arr[1] + ",200s=" + arr[2] + ",100s=" + arr[3]
				+ ", Total=" + CurrentBalance(arr));

	}

	private static int CurrentBalance(int[] arr) {

		return (arr[0] * 2000) + (arr[1] * 500) + (arr[2] * 200) + (arr[3] * 100);
	}

	public static void withdraw(int[] arr, Scanner sc) {
		int cb = CurrentBalance(arr);
		System.out.println("Enter amount");
		int amt = sc.nextInt();

		if (amt == 0 || amt < 0 || amt > cb) {
			System.out.println("incorrect or insufficient funds");
			return;
		}
		int twoThousand = 0, fiveHundred = 0, twoHundred = 0, hundred = 0;
		int two2000 = 0, five500 = 0, two200 = 0, one100 = 0;

		if (amt >= 2000) {
			twoThousand = amt / 2000;
			two2000 = twoThousand;
			if (arr[0] >= twoThousand) {
				arr[0] = arr[0] - twoThousand;
				amt = amt - (twoThousand * 2000);
				// System.out.println("Remaining amount: " + amt);
			} else {
				two2000 = arr[0];
				twoThousand = twoThousand - arr[0];
				arr[0] = 0;
				amt = amt - (two2000 * 2000);
				// System.out.println("Remaining amount: " + amt);
			}
		}
		if (amt >= 500) {
			fiveHundred = amt / 500;
			five500 = fiveHundred;
			if (arr[1] >= fiveHundred) {
				arr[1] = arr[1] - fiveHundred;
				amt = amt - (fiveHundred * 500);
				// System.out.println("Remaining amount: " + amt);
			} else {
				five500 = arr[1];
				fiveHundred = fiveHundred - arr[1];
				arr[1] = 0;
				amt = amt - (five500 * 500);
				// System.out.println("Remaining amount: " + amt);
			}

		}
		if (amt >= 200) {
			twoHundred = amt / 200;
			two200 = twoHundred;
			if (arr[2] >= twoHundred) {
				arr[2] = arr[2] - twoHundred;
				amt = amt - (twoHundred * 200);
				// System.out.println("Remaining amount: " + amt);
			} else {
				two200 = arr[2];
				twoHundred = twoHundred - arr[2];
				arr[2] = 0;
				amt = amt - (two200 * 200);
				// System.out.println("Remaining amount: " + amt);
			}
		}
		if (amt >= 100 && amt <= 200) {
			hundred = amt / 100;
			one100 = hundred;
			if (arr[3] > hundred) {
				arr[3] = arr[3] - hundred;
				amt = amt - (hundred * 100);
				// System.out.println("Remaining amount: " + amt);
			} else {

				one100 = arr[3];
				hundred = hundred - arr[3];
				arr[3] = 0;
				amt = amt - (one100 * 100);
				// System.out.println("Remaining amount: " + amt);
			}
		}

		System.out.println("Dispensed: 2000s=" + two2000 + ",500s=" + five500 + ",200s=" + two200 + ",100s=" + one100);

		System.out.println("Balance: 2000s=" + arr[0] + ",500s=" + arr[1] + ",200s=" + arr[2] + ",100s=" + arr[3]
				+ ", Total=" + CurrentBalance(arr));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// array for holding the denomination
		// in the begining assign 0 values to all the notes
		int[] arr = new int[] { 0, 0, 0, 0 };
		int cb = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.For Deposit money \n2.For Withdraw money \n3.Current Account Balance \n4. Exit ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				deposit(arr, sc);
				cb = CurrentBalance(arr);
				break;
			case 2:
				withdraw(arr, sc);
				break;
			case 3:
				System.out.println("Bank Balance: " + CurrentBalance(arr));
				break;
			case 4:
				return;
			}

		}

	}

}
