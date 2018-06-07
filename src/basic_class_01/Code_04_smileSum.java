package basic_class_01;
//小和问题
//和归并排序相同的操作流程，在merger过程中左指针小于右指针责认为左边的数是右边所有数的小和
public class Code_04_smileSum {

	public static void smileSum(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		int a = mergerSort(arr , 0 , arr.length -1);
		
		System.out.println(a);
	}
	
	public static int mergerSort(int[] arr , int l , int r) {
		if (l == r) {
			return 0;
		}
		
		int mid = l + ((r - l) >> 1);
		return mergerSort(arr , l , mid) + mergerSort(arr , mid + 1 , r) + merger(arr , l , mid , r);
	}
	
	public static int merger(int[] arr , int l , int mid , int r) {
		int[] help = new int[r - l + 1];
		int p1 = l;
		int p2 = mid + 1;
		int i = 0;
		int res = 0;
		while(p1 <= mid && p2 <= r) {
			res = arr[p1] < arr[p2] ? (r - p2 +1) * arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		
		while(p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while(p2 <= r) {
			help[i++] = arr[p2++];
		}
		
		for(i = 0 ; i < help.length ; i ++) {
			arr[l + i] = help[i];
		}
		
		return res;
		
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 4545, 3432, 667, 231, 4543, 21321, 76, 23 };
		smileSum(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
}
