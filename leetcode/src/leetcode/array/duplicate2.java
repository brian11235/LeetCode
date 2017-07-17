package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class duplicate2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	Map<Integer,Integer> numsMap = new HashMap<Integer,Integer>();
    	int j;
		if(null==nums){
			return false;
		}
		for(int i = 0 ; i < nums.length ; i ++){
			if(numsMap.containsKey(nums[i])){
				j=numsMap.get(nums[i]);
				if(i-j<=k){
					return true;
				}
			}
			numsMap.put(nums[i], i);
		}
		return false;  
    }
	public static void main(String[] args){
		//int[] nums1={1,3,5,2,9,9,9,9};
		int[] nums1={1,2,1,1};
		containsNearbyDuplicate(nums1,1);
		
	}
}
