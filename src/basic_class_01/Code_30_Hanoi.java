package basic_class_01;
//��ŵ������
public class Code_30_Hanoi {
	public static long i = 0;
	//��ŵ������ĵݹ����
	public static void process(int N , String from , String to , String help) {
		if(N == 1) {
			i++;
			System.out.println(N+"��"+from+"�ƶ���"+to);
		}else {
			//��n-1�ƶ�������λ��
			process(N - 1,from , help , to);
			i++;
			System.out.println(N+"��"+from+"�ƶ���"+to);
			//��n-1λ���ƶ�����ȷλ��
			process(N - 1,help , to , from);
		}
	}
	
	public static void main(String[] args) {
		process(15,"��","��","��");
		System.out.println(i);
	}
}
