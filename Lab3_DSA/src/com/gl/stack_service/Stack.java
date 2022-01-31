package com.gl.stack_service;

class Node {
	char data;
	Node next;

	public Node() {
		data = Character.MIN_VALUE;
		next = null;
	}
}

public class Stack {

	Node top;
	private static long MAX_LIMIT = 100000;
	private static long CURR_STACK_SIZE = 0;

	public Stack() {
		top = null;
	}

	private static void updateStackSize(boolean isAdded) {
		if (isAdded) {
			++CURR_STACK_SIZE;
		} else {
			--CURR_STACK_SIZE;
		}
	}

	public boolean isEmpty() {
		return (top == null) || (CURR_STACK_SIZE == 0);
	}

	private Node createNewNode(char data) {
		Node newNode = new Node();
		if (newNode != null) {
			newNode.data = data;
		}
		return newNode;
	}

	public void push(char data) {
		Node newNode = createNewNode(data);
		if (newNode == null || CURR_STACK_SIZE == MAX_LIMIT) {
			System.out.println("Stack Overflow");
			return;
		}
		newNode.next = top;
		top = newNode;
		updateStackSize(true);
	}

	public char pop() {
		char data = Character.MIN_VALUE;
		if (isEmpty()) {
			// System.out.println("Stack is Empty");
			return data;
		}

		data = top.data;
		Node temp = top;
		top = temp.next;
		temp = null;
		updateStackSize(false);
		return data;
	}

	public char peek() {
		if (!isEmpty())
			return top.data;
		return Character.MIN_VALUE;
	}

	public void display() {
		Node temp = top;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
