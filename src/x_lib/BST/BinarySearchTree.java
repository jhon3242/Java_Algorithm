package x_lib.BST;

public class BinarySearchTree {
	class Node{
		int value;
		Node left;
		Node right;

		Node(int value){
			this.value = value;
		}
	}
	// 검색
	public Node circularSearch(Node node, int key){
		if (node == null){
			return null;
		}

		if (node.value == key){
			return node;
		} else if (node.value > key) {
			return circularSearch(node.left, key);
		} else {
			return circularSearch(node.right, key);
		}
	}

	// 삽입
	public Node insertNode(Node node, int key) {
		if (node == null) {
			return new Node(key);
		}

		if (node.value == key){
			return node;
		} else if (node.value > key) {
			node.left = insertNode(node.left, key);
		} else {
			node.right = insertNode(node.right, key);
		}
		return node;
	}

	// 삭제
	public Node deleteNode(Node node, int key) {
		if (node == null) {
			return null;
		}

		if (node.value > key) {
			node.left = deleteNode(node.left, key);
		} else if (node.value < key) {
			node.right = deleteNode(node.right, key);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
			Node replaceNode = minValueNode(node.right);
			node.value = replaceNode.value;
			node.right = deleteNode(node.right, replaceNode.value);
		}
		return node;
	}

	public Node minValueNode(Node node) {
		Node cur = node;
		while (cur.left != null) {
			cur = cur.left;
		}
		node.left = null;
		return cur;
	}

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();

		Node root = binarySearchTree.insertNode(null, 10);
		binarySearchTree.insertNode(root, 9);
		binarySearchTree.insertNode(root, 15);
		binarySearchTree.insertNode(root, 20);
		binarySearchTree.insertNode(root, 4);
		binarySearchTree.insertNode(root, 1);
		binarySearchTree.insertNode(root, 5);

		Node search = binarySearchTree.circularSearch(root, 5);
		System.out.println("search.value = " + search.value);

		binarySearchTree.deleteNode(root, 9);
		System.out.println("root.left.value = " + root.left.value);
	}
}

