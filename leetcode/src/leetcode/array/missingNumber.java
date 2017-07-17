package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class missingNumber {
	 	public static int missingNumber(int[] nums) {
	 		List<Integer> resultArray = new ArrayList<Integer>();
	 		for(int i:nums){
	 			resultArray.add(i);
	 		}
	 		for(int i=0 ; i < nums.length ; i++){
	 			if(!(resultArray.contains(i))){
	 				return i;
	 			}
	 		}
	 		return nums.length;
	    }
	 	public static void main(String[] args){
			int[] nums={1,0};
			missingNumber(nums);
		}
}
