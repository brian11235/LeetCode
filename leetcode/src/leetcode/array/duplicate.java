package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class duplicate {
	public static boolean containsDuplicate(int[] nums) {
		Map<Integer,Integer> numsMap = new HashMap<Integer,Integer>();
		if(null==nums){
			return false;
		}
		for(int i = 0 ; i < nums.length ; i ++){
			if(numsMap.containsKey(nums[i])){
				return true;
			}else{
				numsMap.put(nums[i], 1);
			}
		}
		return false;
        
    }
	public static void main(String[] args){
		//int[] nums1={1,3,5,2,9,9,9,9};
		int[] nums1={1,2,3,4,5,2};
		containsDuplicate(nums1);
		
	}
}
