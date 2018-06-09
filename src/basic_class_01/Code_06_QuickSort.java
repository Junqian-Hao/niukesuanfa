package basic_class_01;


//快速排序
//该过程无法使用异或交换
//快速排序的空间复杂度为O（logN）
public class Code_06_QuickSort {
	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			//加这一行后变成随机快排，长期期望时间复杂度为O（n*logn）
			swap(arr , l + (int) (Math.random() * (r - l + 1)) , r);
			int[] a = partition(arr , l , r);
			quickSort(arr , l , a[0] - 1);
			quickSort(arr , a[1] + 1 , r);
		}
	}

	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r]) {
				swap(arr , ++less , l++);
			}else if(arr[l] > arr[r]) {
				swap(arr , --more , l);
			}else {
				l++;
			}
		}
		
		swap(arr , more , r);
		return new int[] {less + 1 , more};
	}

	public static void swap(int[] arr, int a, int b) {
		int tem = arr[a];
		arr[a] = arr[b];
		arr[b] = tem;
	}
	
//	public static void swap(int[] arr, int i, int j) {
//		arr[i] = arr[i] ^ arr[j];
//		arr[j] = arr[i] ^ arr[j];
//		arr[i] = arr[i] ^ arr[j];
//	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 4545, 3432, 667, 231, 4543, 21321, 76, 23 };
		quickSort(arr , 0 , arr.length - 1);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		
	}
}
