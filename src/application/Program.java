package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String name = sc.nextLine();
			System.out.print("Initial balance: ");
			double ib = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double limit = sc.nextDouble();
			Account acc = new Account(num, name, ib, limit);
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			acc.withDraw(amount);
			System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
		}
		catch(DomainExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		
		sc.close();
	}

}
