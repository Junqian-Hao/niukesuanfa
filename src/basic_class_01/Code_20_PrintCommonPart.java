package basic_class_01;
//打印俩个排好序的链表相同的部分
public class Code_20_PrintCommonPart {
	public static class Node {
		public int data;
		public Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void printCommonPart(Node head1 , Node head2) {
		System.out.println("俩个链表相同的部分：");
		while(head1 != null && head2 != null) {
			if(head1.data < head2.data) {
				head1 = head1.next;
			}else if(head1.data > head2.data) {
				head2 = head2.next;
			}else {
				System.out.print(head1.data + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
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
		Node node1 = new Node(2);
		node1.next = new Node(3);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(6);

		Node node2 = new Node(1);
		node2.next = new Node(2);
		node2.next.next = new Node(5);
		node2.next.next.next = new Node(7);
		node2.next.next.next.next = new Node(8);

		printLinkedList(node1);
		printLinkedList(node2);
		printCommonPart(node1, node2);

	}
}
