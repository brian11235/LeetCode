package leetcode.binarySearch;

import java.util.Arrays;
/**
 * 排序之後, 找出前後相等的數
 * @author brian
 *
 */
public class FindtheDuplicateNumber {
	public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i<nums.length-1 ; i++){
            if(nums[i+1]-nums[i]==0){
                return nums[i];
            }
        }
        return 0;
    }
}
