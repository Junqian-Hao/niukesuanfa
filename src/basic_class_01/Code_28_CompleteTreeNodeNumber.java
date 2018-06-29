package basic_class_01;
//����ȫ�������Ľڵ������ʱ�临�Ӷȵ���O��N��
public class Code_28_CompleteTreeNodeNumber {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	//����ȫ�������Ľڵ����
	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}
	
	/**
	 * @param node ��ǰ�ڵ�
	 * @param l ��ǰ�ڵ����ڵĲ���
	 * @param h ��ǰ����������
	 * @return node�½ڵ����
	 */
	public static int bs(Node node, int l, int h) {
		if (l == h) {
			return 1;
		}
		//�ж�����������߽��Ƿ����һ��
		if(mostLeftLevel(node.right , l +1) == h) {
			//�����һ�㣬������
			return (1 << (h - l)) + bs(node.right , l + 1 , h); 
		}else {
			//û�����һ�㣬��������������һ��
			return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
		}
	}
	
	
	//��֪��ǰ�ڵ㴦��leve������ȫ����������
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
