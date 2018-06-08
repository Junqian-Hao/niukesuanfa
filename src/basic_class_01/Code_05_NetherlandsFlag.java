package basic_class_01;

//������������
//�������бȸ���ֵС�ķ���ߵ��ڵķ��ұߴ��ڵķ��ұ�
public class Code_05_NetherlandsFlag {
	//���ص�������Ŀ�ʼ������±�����
	public static int[] partition(int[] arr, int l, int r, int num) {
		int less = l - 1; // С������ָ��
		int more = r + 1; // ��������ָ��
		int cur = l; // ����ָ��

		while (cur < more) {
			if (arr[cur] < num) {
				swap(arr, ++less, cur++);
			} else if (arr[cur] > num) {
				swap(arr, --more, cur);
			} else {
				cur++;
			}
		}
		return new int[] {less + 1 , more -1};
	}

	public static void swap(int[] arr, int a, int b) {
		arr[a] = arr[a] ^ arr[b];
		arr[b] = arr[a] ^ arr[b];
		arr[a] = arr[a] ^ arr[b];
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 4545, 3432, 667, 231, 4543, 21321, 76, 23 , 667,667,23432,324432};
		int[] a = partition(arr , 0 , arr.length - 1 , 667);
		for(int b : a) {
			System.out.println(b);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
}
