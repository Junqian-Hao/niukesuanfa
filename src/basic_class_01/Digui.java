package basic_class_01;

//×î¼òµ¥µÄµÝ¹é
public class Digui {

	public static void main(String[] args) {
		int[] arr = {123,21321,5324,321,534};
		
		int max = getMax(arr,0 , arr.length-1);
		System.out.println(max);

	}

	public static int getMax(int[] arr, int l, int r) {
		if (l == r) {
			return arr[l];
		}

		int mid = (l + r) / 2;
		int maxl = getMax(arr, l, mid);
		int maxr = getMax(arr, mid + 1, r);

		return maxl > maxr ? maxl : maxr;
	}

}
