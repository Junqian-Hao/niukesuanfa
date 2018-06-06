package basic_class_01;

//归并排序
public class Code_03_MergerSort {
	public static void mergerSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		mergerSort(arr, 0, arr.length - 1);

	}

	public static void mergerSort(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		// 求中点 相当于 l + ((r - l) / 2)
		int mid = l + ((r - l) >> 1);

		mergerSort(arr, l, mid);
		mergerSort(arr, mid + 1, r);
		merger(arr, l, mid, r);

	}

	public static void merger(int[] arr, int l, int mid, int r) {
		int[] help = new int[r - l + 1];
		int p1 = l;
		int p2 = mid + 1;
		int i = 0;

		while (p1 <= mid && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}

		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}

		while (p2 <= r) {
			help[i++] = arr[p2++];
		}

		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}

	}

	public static void main(String[] args) {
		int[] arr = { 1, 4545, 3432, 667, 231, 4543, 21321, 76, 23 };
		mergerSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

}
