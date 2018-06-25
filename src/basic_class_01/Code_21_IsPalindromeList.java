package basic_class_01;
import java.util.*;
//判断一个链表是否是回文链表
public class Code_21_IsPalindromeList {
	public static class Node{
		public int data;
		public Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static boolean isPalindrome1(Node head) {
		if(head == null) {
			return false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		Node a = head;
		while(a != null) {
			stack.push(a.data);
			a = a.next;
		}
		a = head;
		while(a != null) {
			if (stack.pop() != a.data) {
				return false;
			}
			a = a.next;
		}
		return true;
	}
	public static boolean isPalindrome2(Node head) {
		if (head == null) {
			return false;
		}
		Node q = head;
		Node s = head.next;
		
		while(q.next != null && q.next.next != null) {
			q = q.next.next;
			s = s.next;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(s != null) {
			stack.push(s.data);
			s = s.next;
		}
		
		q = head;
		
		while(!stack.isEmpty()) {
			if(stack.pop() != q.data) {
				return false;
			}
			q = q.next;
		}
		
		return true;
		
	}
	
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		Node head = null;
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
//		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
//		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
//		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
//		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
//		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
//		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
//		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
//		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
//		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

	}
}
