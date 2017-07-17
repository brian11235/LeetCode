package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class disappearedNumbers {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int count = nums.length;
		List<Integer> result=new ArrayList<Integer>();
		for(int i=0; i< nums.length; i++){
			if(nums[i]!=nums[nums[i]-1]){
				int original = nums[i];
				nums[i]=nums[nums[i]-1];
				nums[original-1]=original;
				i--;
			}
		}
		for(int i=0; i<nums.length;i++){
			if(nums[i]!=i+1){
				result.add(i+1);
			}
		}
		return result;
        
    }
	public static void main(String[] args){
		int[] nums={4,3,2,7,8,2,3,1};
		findDisappearedNumbers(nums);
	}
}
