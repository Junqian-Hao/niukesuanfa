package basic_class_01;
//—°‘Ò≈≈–Ú
public class Code_01_SelectionSort {
	public static void selectionSort(int[] arr) {
		for(int i = 0 ; i < arr.length - 1 ; i ++) {
			int minIndex = i;
			for(int j = i +1 ; j < arr.length ; j ++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
				swap(arr,i,minIndex);
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
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
}
