package leetcode.array;
/**
 * quickSort排序
 * @author brian
 *
 */
public class KthLargestElementinanArray {
	public static int findKthLargest(int[] nums, int k) {
		nums=quickSort(nums,0,nums.length-1);
		return nums[nums.length-k];
    }
	public static int[] quickSort(int[] arr, int low, int high){
		if (arr == null || arr.length == 0){
			return arr;
		}
		if (low >= high){
			return arr;
		}
		//// pick the pivot
		int pivot = arr[low];
		int i = low+1, j=high;
		while (i <= j) {
			while (i<arr.length&&arr[i] < pivot ) {
				i++;
			}
			while (j<arr.length&&arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		int temp = arr[low];
		arr[low]= arr[j];
		arr[j] = temp;
		if (low < j){
			quickSort(arr, low, j-1);
		}
		if (high > i){
			quickSort(arr, i, high);
		}
		return arr;
	}
	public static void main(String[] args){
		int[] nums={2,1};
		findKthLargest(nums,1);
	 }
}
//if (arr == null || arr.length == 0)
//	return arr;
//
//if (low >= high)
//	return arr;
//
//// pick the pivot
//int middle = low + (high - low) / 2;
//int pivot = arr[middle];
//
//// make left < pivot and right > pivot
//int i = low, j = high;
//while (i <= j) {
//	while (arr[i] < pivot) {
//		i++;
//	}
//
//	while (arr[j] > pivot) {
//		j--;
//	}
//
//	if (i <= j) {
//		int temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
//		i++;
//		j--;
//	}
//}
//
//// recursively sort two sub parts
//if (low < j){
//	quickSort(arr, low, j);
//}
//if (high > i){
//	quickSort(arr, i, high);
//}
//return arr;