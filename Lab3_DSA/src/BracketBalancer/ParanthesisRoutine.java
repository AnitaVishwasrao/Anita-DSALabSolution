package BracketBalancer;

import com.gl.stack_service.Stack;

public class ParanthesisRoutine {

	private boolean isBracketPair(char bracket1, char bracket2) {
		return ((bracket1 == '(' && bracket2 == ')') || (bracket1 == '{' && bracket2 == '}')
				|| (bracket1 == '[' && bracket2 == ']'));
	}

	private boolean isOpeningBracket(char bracket) {
		return (bracket == '(' || bracket == '{' || bracket == '[');
	}

	private boolean isClosingBracket(char bracket) {
		return (bracket == ')' || bracket == '}' || bracket == ']');
	}

	public void checkIfBalancedBrackets(String brackets) {
		Stack stack = new Stack();

		for (int i = 0; i < brackets.length(); i++) {
			char bracket = brackets.charAt(i);

			if (isOpeningBracket(bracket)) {
				stack.push(bracket);
			} else if (isClosingBracket(bracket)) {
				char poppedEle = stack.pop();
				if ((poppedEle == Character.MIN_VALUE) || !isBracketPair(poppedEle, bracket)) {
					System.out.println("The entered Strings do not contain Balanced Brackets");
					return;
				}

			} else {
				System.out.println("Invalid bracket character");
			}
		}

		if (stack.isEmpty()) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}
}
