package basic_class_01;
//给定一个数组，求如果排序之后，相邻两数的最大差值，要求时
//间复杂度O(N)，且要求不能用非基于比较的排序。
public class Code_08_MaxGap {
	public static int maxGap(int[] nums) {
		if(nums == null || nums.length < 2) {
			return 0;
		}	
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < len ; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		
		if(min == max) {
			return 0 ;
		}
		
		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len + 1];
		int[] mins = new int[len + 1];
		int bid = 0;
		
		for(int i = 0 ; i < len ; i++) {
			bid = bucket(nums[i] , len , min , max);
			mins[bid] = hasNum[bid] ? Math.min(nums[bid] , mins[bid]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.min(nums[bid] , maxs[bid]) : nums[i];
			hasNum[bid] = true;
		}
		
		int res = 0;
		int lastMax = maxs[0];
		int i = 1;
		
		for(; i <= len ; i ++) {
			if(hasNum[i]) {
				res = Math.max(res,mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		
		return res;
		
	}
	
	public static int bucket(long num , long len , long min , long max) {
		return (int) ((num - min ) * len / (max -min));
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 4545, 3432, 66217, 231, 4543, 213221, 76, 23 };
		int max = maxGap(arr);
		System.out.println(max);
		
	}
}
