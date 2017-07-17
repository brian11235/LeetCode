package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class LargestDivisibleSubset {
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> maxResult = new ArrayList<Integer>();
		List<Integer> tempList = new ArrayList<Integer>();
		if(nums==null||nums.length==0){
			return maxResult;
		}
		maxResult.add(nums[0]);
		for(int i=1; i<nums.length ;i++){
			for(int j =0 ; j < i ; j++){
				if(nums[j]%nums[i]==0||nums[i]%nums[j]==0){
					tempList.add(nums[j]);
				}
			}
			tempList.add(nums[i]);
			if(tempList.size()>maxResult.size()){
				maxResult.clear();
				maxResult.addAll(tempList);
			}
			tempList.clear();
		}
		
		
		return maxResult;
        
    }
	public static void main(String[] args){
		int[] nums = {1,9,5,3,15,25};
		largestDivisibleSubset(nums);
	}
}
