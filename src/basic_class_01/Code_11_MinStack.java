package basic_class_01;

import java.util.*;

//实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
//回栈中最小元素的操作。
public class Code_11_MinStack {
	private Stack<Integer> data = new Stack<Integer>();
	private Stack<Integer> min = new Stack<Integer>();

	// 压栈
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
			throw new Exception("当前栈空，无法弹出");
		}
		min.pop();
		return data.pop();
	} 
	
	public int getMin() throws Exception{
		if(data.isEmpty()) {
			throw new Exception("当前栈空无最小元素");
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
