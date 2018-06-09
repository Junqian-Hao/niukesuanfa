package basic_class_01;

//������
public class Code_07_HeapSort {
	public static void heapSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		
		//�������ɴ����
		for(int i = 0 ; i < arr.length ; i++) {
			heapInsert(arr , i);
		}
		
		int heapSize = arr.length;
		swap(arr , 0 , --heapSize);
		while(heapSize > 0) {
			heapify(arr , 0 , heapSize);
			swap(arr , 0 ,--heapSize);
		}
		
		
	}
	
	//������indexλ���ϵ�Ԫ�ز���ѣ�Ҫ��ǰindex��Ԫ���Ѿ��Ƕ�
	public static void heapInsert(int[] arr , int index) {
		while(arr[index] > arr[(index - 1) / 2]) {
			swap(arr , index , (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}
	
	//index λ���ϵ�ֵ��С�������Ϊ����� �� heapSize����Ѵ�С
	public static void heapify(int[] arr , int index , int heapSize) {
		int left = index * 2 + 1;
		while(left < heapSize) {
			int largest = left+1 < heapSize && arr[left + 1] > arr[left] ? 
					left + 1 : left;
			
			largest = arr[index] > arr[largest] ? index : largest;
			if(largest == index) {
				break;
			}
			swap(arr , index , largest);
			index = largest;
			left = index * 2 + 1;
		}
	}
	
	public static void swap(int[] arr , int a, int b) {
		int tem = arr[a];
		arr[a] = arr[b];
		arr[b] = tem;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 4545, 3432, 667, 231, 4543, 21321, 76, 23 };
		heapSort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		
	}
}
