package leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class majorityElement {
	public static int majorityElement(int[] nums) {
		int count;
		int sumCount=0;
		double size= nums.length;
		Map<Integer,Integer> newMap = new HashMap<Integer,Integer>();
		for(int i=0; i < nums.length ; i++){
			if(newMap.containsKey(nums[i])){
				count=newMap.get(nums[i]);
				count++;
				newMap.put(nums[i], count);
			}else{
				count=1;
				newMap.put(nums[i], count);
			}
			if(count>=size/2){
				return nums[i];
			}
		}	
		return 0;
        
    }
	public static void main(String[] args){
		//int[] nums1={1,3,5,2,9,9,9,9};
		int[] nums1={2,2,1,1,1,2,2};
		majorityElement(nums1);
		
	}
}
