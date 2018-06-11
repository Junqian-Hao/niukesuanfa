package basic_class_01;
//使用数组模拟栈
public class Code_09_ArrayStack {
	private int[] data ;
	private int size;
	
	public Code_09_ArrayStack(int size) throws Exception {
		if(size < 0) {
			throw new Exception(" 栈大小不能小于0");
		}
		data = new int[size];
		this.size = 0;
	}
	
	//返回栈顶元素
	public Integer peek() {
		if(size == 0) {
			return null;
		}
		return data[size - 1];
	}
	//弹出栈顶元素
	public Integer pop() throws Exception {
		if(size == 0) {
			throw new Exception("当前栈空无法弹出");
		}
		return data[--size];
	}
	//压栈
	public void push(int obj) throws Exception {
		if(size == data.length) {
			throw new Exception("当前栈满，无法压如");
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
