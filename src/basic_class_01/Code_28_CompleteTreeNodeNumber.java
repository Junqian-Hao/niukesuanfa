package basic_class_01;
//求完全二叉树的节点个数，时间复杂度低于O（N）
public class Code_28_CompleteTreeNodeNumber {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	//求完全二叉树的节点个数
	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}
	
	/**
	 * @param node 当前节点
	 * @param l 当前节点所在的层数
	 * @param h 当前二叉树树高
	 * @return node下节点个数
	 */
	public static int bs(Node node, int l, int h) {
		if (l == h) {
			return 1;
		}
		//判断右子树的左边界是否到最后一层
		if(mostLeftLevel(node.right , l +1) == h) {
			//到最后一层，左树满
			return (1 << (h - l)) + bs(node.right , l + 1 , h); 
		}else {
			//没到最后一层，右子树满但是少一层
			return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
		}
	}
	
	
	//已知当前节点处于leve层求完全二叉树树高
	public static int mostLeftLevel(Node node , int leve) {
		while(node != null) {
			leve ++;
			node = node.left;
		}
		return leve - 1;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}
}
