package basic_class_01;
//��ֽ����
public class Code_32_PagerFolding {
	public static void printAllFolding(int N) {
		printFloding(1,N,true);
	}
	public static void printFloding(int i , int N , boolean isDown) {
		if(i>N) {
			return;
		}
		printFloding(i+1, N, true);
		System.out.println(isDown? "��":"��");
		printFloding(i+1,N,false);
	}
	public static void main(String[] args) {
		printAllFolding(1000);
	}
}
