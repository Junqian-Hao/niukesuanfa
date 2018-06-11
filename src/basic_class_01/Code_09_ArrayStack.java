package basic_class_01;
//ʹ������ģ��ջ
public class Code_09_ArrayStack {
	private int[] data ;
	private int size;
	
	public Code_09_ArrayStack(int size) throws Exception {
		if(size < 0) {
			throw new Exception(" ջ��С����С��0");
		}
		data = new int[size];
		this.size = 0;
	}
	
	//����ջ��Ԫ��
	public Integer peek() {
		if(size == 0) {
			return null;
		}
		return data[size - 1];
	}
	//����ջ��Ԫ��
	public Integer pop() throws Exception {
		if(size == 0) {
			throw new Exception("��ǰջ���޷�����");
		}
		return data[--size];
	}
	//ѹջ
	public void push(int obj) throws Exception {
		if(size == data.length) {
			throw new Exception("��ǰջ�����޷�ѹ��");
		}
		data[size++] = obj;
	}
	
	 public static void main(String[] args) throws Exception {
		Code_09_ArrayStack stack = new Code_09_ArrayStack(3);
		stack.push(1);
		stack.push(2);
		int a = stack.peek();
		System.out.println(a);
		int b = stack.pop();
		System.out.println(b);
		b = stack.pop();
		System.out.println(b);
	}
	
}
