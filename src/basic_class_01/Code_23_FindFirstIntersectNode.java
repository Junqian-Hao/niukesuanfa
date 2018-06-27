package basic_class_01;

//查找俩个单链表的第一个相交点
public class Code_23_FindFirstIntersectNode {
	public static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	// 获得俩链表的相交节点
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);

		if (loop1 == null && loop2 == null) {
			// 俩个链表都无环
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			// 俩个链表都有环
			return bothLoop(head1, loop1, head2, loop2);
		}
		// 一个链表有环一个五环一定不相交
		return null;
	}

	// 如果链表有环返回入环节点无环返回null
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next;// 慢指针一次走一步
		Node n2 = head.next.next;// 快指针一次走俩步
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n1 = n1.next;
			n2 = n2.next.next;
		}
		// 快指针回到起点一次走一步
		n2 = head;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}

		return n1;
	}

	// 俩个无环链表相交
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;// 第一个链表的尾指针
		Node cur2 = head2;// 第一个链表的头指针
		int n = 0;// 记录俩个链表的长度差值
		while (cur1 != null) {
			cur1 = cur1.next;
			n++;
		}
		while (cur2 != null) {
			cur2 = cur2.next;
			n--;
		}

		if (cur1 != cur2) {
			// 俩个链表的尾指针不相等说明不相交
			return null;
		}
		// 指针回到头部 cur1指向较长的指针 cur2指向较短的指针

		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);

		// 较长的链表向前走n步
		while (n != 0) {
			cur1 = cur1.next;
			n--;
		}

		// 俩个指针同时向前走，直到相等为入环节点
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	// 有环节点的相交问题
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		// 入环位置相同相交点不在环上 求法与无环相同
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
}
