package basic_class_01;

//荷兰国旗问题
//将数组中比给定值小的放左边等于的放右边大于的放右边
public class Code_05_NetherlandsFlag {
	//返回等于区域的开始与结束下标索引
	public static int[] partition(int[] arr, int l, int r, int num) {
		int less = l - 1; // 小于区域指针
		int more = r + 1; // 大于区域指针
		int cur = l; // 遍历指针

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
