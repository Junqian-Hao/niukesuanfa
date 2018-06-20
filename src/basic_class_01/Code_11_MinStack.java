package basic_class_01;

import java.util.*;

//ʵ��һ�������ջ����ʵ��ջ�Ļ������ܵĻ����ϣ���ʵ�ַ�
//��ջ����СԪ�صĲ�����
public class Code_11_MinStack {
	private Stack<Integer> data = new Stack<Integer>();
	private Stack<Integer> min = new Stack<Integer>();

	// ѹջ
	public void push(int obj) {
		data.push(obj);
		if (min.empty() || min.peek() > obj) {
			min.push(obj);
		} else {
			min.push(min.peek());
		}
	}
	
	public int pop() throws Exception{
		if(data.isEmpty()) {
			throw new Exception("��ǰջ�գ��޷�����");
		}
		min.pop();
		return data.pop();
	} 
	
	public int getMin() throws Exception{
		if(data.isEmpty()) {
			throw new Exception("��ǰջ������СԪ��");
		}
		return min.peek();
	}
	public static void main(String[] args) throws Exception {
		Code_11_MinStack stack = new Code_11_MinStack();
		stack.push(1);
		int b = stack.getMin();
		System.out.println(b);
		stack.push(2);
		b = stack.getMin();
		System.out.println(b);
	}
	
}
