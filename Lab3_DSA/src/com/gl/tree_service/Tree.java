package com.gl.tree_service;

import java.util.LinkedList;

public class Tree {

	static class Node {
		int data;
		Node left, right;

		public Node() {
			data = -1;
			left = null;
			right = null;
		}
	}

	public Node root;

	private Node createNewNode(int data) {
		Node newNode = new Node();
		newNode.data = data;
		return newNode;
	}

	public void insertNode(int data) {
		Node newNode = createNewNode(data);
		Node x = root;
		Node current_parent = null;

		while (x != null) {
			current_parent = x;
			if (data < x.data)
				x = x.left;
			else if (data > x.data)
				x = x.right;
			else {
				return;
			}
		}

		if (current_parent == null) {
			current_parent = newNode;
			this.root = current_parent;
		}

		else if (current_parent.data < data)
			current_parent.right = newNode;
		else
			current_parent.left = newNode;

	}

	public void printInorder(Node root) {
		if (root == null) {
			return;
		} else {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	private LinkedList<Integer> longestPath(Node root) {
		if (root == null) {
			//System.out.println("Tree is empty");
			return new LinkedList<Integer>();
		}

		LinkedList<Integer> leftSubTree = longestPath(root.left);
		LinkedList<Integer> rightSubTree = longestPath(root.right);

		if (leftSubTree.size() > rightSubTree.size())
			leftSubTree.add(root.data);
		else
			rightSubTree.add(root.data);

		return leftSubTree.size() > rightSubTree.size() ? leftSubTree : rightSubTree;
	}

	public void findLongestPath() {
		LinkedList<Integer> longestPath = longestPath(root);
		int lpSize = longestPath.size();
		if (lpSize > 0) {
			System.out.print("Longest path : ");
			for (int i = (lpSize - 1); i >= 0; i--) {
				if (i > 0) {
					System.out.print(longestPath.get(i) + "->");
				} else {
					System.out.print(longestPath.get(i));
				}
			}
		}
		else {
			System.out.print("Tree is empty");
		}
	}

}
