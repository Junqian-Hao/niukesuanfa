package basic_class_01;

//��������������ĵ�һ���ཻ��
public class Code_23_FindFirstIntersectNode {
	public static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	// �����������ཻ�ڵ�
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);

		if (loop1 == null && loop2 == null) {
			// ���������޻�
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			// ���������л�
			return bothLoop(head1, loop1, head2, loop2);
		}
		// һ�������л�һ���廷һ�����ཻ
		return null;
	}

	// ��������л������뻷�ڵ��޻�����null
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next;// ��ָ��һ����һ��
		Node n2 = head.next.next;// ��ָ��һ��������
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n1 = n1.next;
			n2 = n2.next.next;
		}
		// ��ָ��ص����һ����һ��
		n2 = head;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}

		return n1;
	}

	// �����޻������ཻ
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;// ��һ�������βָ��
		Node cur2 = head2;// ��һ�������ͷָ��
		int n = 0;// ��¼��������ĳ��Ȳ�ֵ
		while (cur1 != null) {
			cur1 = cur1.next;
			n++;
		}
		while (cur2 != null) {
			cur2 = cur2.next;
			n--;
		}

		if (cur1 != cur2) {
			// ���������βָ�벻���˵�����ཻ
			return null;
		}
		// ָ��ص�ͷ�� cur1ָ��ϳ���ָ�� cur2ָ��϶̵�ָ��

		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);

		// �ϳ���������ǰ��n��
		while (n != 0) {
			cur1 = cur1.next;
			n--;
		}

		// ����ָ��ͬʱ��ǰ�ߣ�ֱ�����Ϊ�뻷�ڵ�
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	// �л��ڵ���ཻ����
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		// �뻷λ����ͬ�ཻ�㲻�ڻ��� �����޻���ͬ
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
