package LongestPath;

import com.gl.tree_service.Tree;

public class Driver {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insertNode(100);
		tree.insertNode(20);
		tree.insertNode(130);
		tree.insertNode(10);
		tree.insertNode(50);
		tree.insertNode(110);
		tree.insertNode(140);
		tree.insertNode(5);

		
		tree.findLongestPath();
	}
}
