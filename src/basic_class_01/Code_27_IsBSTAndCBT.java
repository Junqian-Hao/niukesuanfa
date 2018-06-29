package basic_class_01;

import java.util.*;
import basic_class_01.Code_24_PreInPosTraversal.Node;

//判断是否是搜索二叉树和平衡二叉树
public class Code_27_IsBSTAndCBT {
	
	//判断是否是搜索二叉树，中序遍历节点值必须升序
	public static boolean isBST(Node head) {
		int v1 = Integer.MIN_VALUE;
		int v2 = Integer.MIN_VALUE;
		
		if(head == null) {
			return true;
		}
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || head != null) {
			if(head != null) {
				stack.push(head);
				head = head.left;
			}else {
				head = stack.pop();
				v2 = v1;
				v1 = head.value;
				if(v1 < v2) {
					return false;
				}
				head = head.right;
				
			}
		}
		return true;
	}
	
	//判断是否是完全二叉树
	//按层遍历
	public static boolean isCBT(Node head) {
		if(head == null) {
			return true;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		boolean leaf = false;
		queue.add(head);
		Node l = null;
		Node r = null;
		while(!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			
			if(leaf&(l != null || r != null) || (l == null && r != null) ) {
				return false;
			}
			if(r == null) {
				leaf = true;
			}
			if(l != null) {
				queue.offer(l);
			}
			if(r != null) {
				queue.offer(r);
			}
		}
		return true;
	}
	
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}
	
	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}
	
	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	
	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);

		printTree(head);
		System.out.println(isBST(head));
		System.out.println(isCBT(head));

	}
}
