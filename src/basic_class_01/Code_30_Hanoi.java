package basic_class_01;
//汉诺塔问题
public class Code_30_Hanoi {
	public static long i = 0;
	//汉诺塔问题的递归求解
	public static void process(int N , String from , String to , String help) {
		if(N == 1) {
			i++;
			System.out.println(N+"从"+from+"移动到"+to);
		}else {
			//将n-1移动到辅助位置
			process(N - 1,from , help , to);
			i++;
			System.out.println(N+"从"+from+"移动到"+to);
			//将n-1位置移动到正确位置
			process(N - 1,help , to , from);
		}
	}
	
	public static void main(String[] args) {
		process(15,"左","右","中");
		System.out.println(i);
	}
}
