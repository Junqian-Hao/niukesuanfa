package basic_class_01;
import java.util.*;
//拿俩个栈实现队列
public class Code_13_TwoStacksQueue {
	private Stack<Integer> pushStack = new Stack<Integer>();
	private Stack<Integer> popStack = new Stack<Integer>();
	
	public void push(int obj) {
		pushStack.push(obj);
	}
	
	public int pop() {
		dao();
		return popStack.pop();
	}
	
	public int peek() {
		dao();
		return popStack.peek();
	}
	
	public void dao() {
		if(!popStack.isEmpty()) {
			return;
		}
		while(!pushStack.isEmpty()) {
			popStack.push(pushStack.pop());
		}
	}
	
	public static void main(String[] args) {
		Code_13_TwoStacksQueue queue = new Code_13_TwoStacksQueue();
		queue.push(1);
		queue.push(2);
		int a = queue.peek();
		System.out.println(a);
		a = queue.pop();
		System.out.println(a);
		a = queue.pop();
		System.out.println(a);
	}
}
