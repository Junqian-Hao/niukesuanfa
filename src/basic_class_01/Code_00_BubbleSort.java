package basic_class_01;

//ð���㷨
public class Code_00_BubbleSort {
	public static void bubble(int[] arr) {
		// ����Ϊ�ջ��߳���Ϊ1ֱ�ӷ���
		if (arr == null || arr.length < 2) {
			return;
		}

		for (int end = arr.length - 1; end > 0; end--) {
			for (int i = 0; i < end; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4545, 3432, 667, 231, 4543, 21321, 76, 23 };
		bubble(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
}
