package basic_class_01;
import java.util.*;
//����������ʵ��ջ
public class Code_12_TwoQueuesStack {
	private Queue<Integer> data = new LinkedList<Integer>();
	private Queue<Integer> help = new LinkedList<Integer>();
	
	public void push(int obj) {
		data.add(obj);
	}
	
	public int pop() throws Exception{
		if(data.isEmpty()) {
			throw new Exception("��ǰջ���޷�����");
		}
		while(data.size() > 1) {
			help.add(data.poll());
		}
		int res = data.poll();
		swap();
		return res;
	}
	
	public int peek() throws Exception{
		if(data.isEmpty()) {
			throw new Exception("��ǰջ���޷�����");
		}
		while(data.size() > 1) {
			help.add(data.poll());
		}
		int res = data.poll();
		help.add(res);
		swap();
		return res;
	}
	
	public void swap() {
		Queue<Integer> tem = data;
		data = help;
		help = tem;
	}
	
	public static void main(String[] args) throws Exception {
		Code_12_TwoQueuesStack stack = new Code_12_TwoQueuesStack();
		stack .push(1);
		stack.push(2);
		int a = stack.peek();
		System.out.println(a);
		a = stack.pop();
		System.out.println(a);
		a = stack.peek();
		System.out.println(a);
		
		
	}
}
