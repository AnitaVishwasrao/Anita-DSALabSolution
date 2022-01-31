package BracketBalancer;

import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Brackets String - ");
		String bracketsInput = scanner.next();
		ParanthesisRoutine pr = new ParanthesisRoutine();
		pr.checkIfBalancedBrackets(bracketsInput);
		scanner.close();
	}
}
