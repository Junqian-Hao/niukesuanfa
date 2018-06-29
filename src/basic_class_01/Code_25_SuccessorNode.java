package basic_class_01;
//在带有父指针的二叉树中查找后继节点（二叉树中序遍历中node的下一个节点称为node的后继节点）
public class Code_25_SuccessorNode {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static Node getSuccessorNode(Node node) {
		if(node == null) {
			return node;
		}
		if(node.right != null) {
			//如果有右子树，后继节点是右子树最左节点
			Node r ;
			r = node.right;
			while(r.left != null) {
				r = r.left;
			}
			return r;
		}else {
			//没有右子树，后继节点看他作为哪一个节点左子树的最后一个节点
			Node parent = node.parent;
			while(parent != null && parent.left != node) {
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}
	

	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getSuccessorNode(test));
	}
}
