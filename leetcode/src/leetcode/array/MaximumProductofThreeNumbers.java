package leetcode.array;

import java.util.Arrays;

public class MaximumProductofThreeNumbers {
	public int maximumProduct(int[] nums) {
		int posMax;
		int negMax;
		int len = nums.length;
		Arrays.sort(nums);
		posMax = nums[len-1]*nums[len-2]*nums[len-3];
		negMax = nums[0]*nums[1]*nums[len-1];
		return Math.max(posMax, negMax);
    }
}
