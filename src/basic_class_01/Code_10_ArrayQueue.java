package basic_class_01;

//使用数组模拟队列
public class Code_10_ArrayQueue {
	private int[] data;
	private int size;
	private int start;
	private int end;

	public Code_10_ArrayQueue(int size) throws Exception {
		if (size < 0) {
			throw new Exception(" 队大小不能小于0");
		}
		data = new int[size];
		this.size = 0;
		this.start = 0;
		this.end = 0;
	}

	// 返回队头元素
	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return data[start];
	}

	// 弹出队头元素
	public Integer pop() throws Exception {
		if (size == 0) {
			throw new Exception("当前队空无法弹出");
		}
		size--;
		int tem = start;
		start = start == data.length - 1 ? 0 : start + 1;
		
		return data[tem];
	}

	// 入队
	public void push(int obj) throws Exception {
		if (size == data.length) {
			throw new Exception("当前队满无法加入");
		}
		size++;
		data[end] = obj;
		end = end == data.length - 1 ? 0 : end + 1;
	}

	public static void main(String[] args) throws Exception {
		Code_10_ArrayQueue stack = new Code_10_ArrayQueue(3);
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
