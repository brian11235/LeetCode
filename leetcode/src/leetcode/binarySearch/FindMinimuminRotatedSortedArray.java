package leetcode.binarySearch;

/**
 * 
 * 幾乎相似於SearchinRotatedSortedArray, 用BS, 找出mid後, if right > mid, j=mid找左邊, if
 * right<mid, i = mid 找右邊 ,直到j跟i差1, 比較最小值 ------------>有缺點, 當測資長度為1時,會無窮迴圈,
 * 所以要多一個判斷(因為 mid 無+1, -1) ----->需在找出更好辦法
 * 
 * 
 * @author brian
 *
 */
public class FindMinimuminRotatedSortedArray {
	public static int findMin(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		int mid;
		if (nums.length == 1) {
			return nums[0];
		}
		while (i <= j) {
			mid = (i + j) / 2;
			if (j - i == 1) {
				return Math.min(nums[j], nums[i]);
			}
			if (nums[mid] > nums[j]) {
				i = mid;
			} else {
				j = mid;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums = { 1 };
		findMin(nums);
	}
}
