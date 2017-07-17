package leetcode.hashMap;

import java.util.HashMap;
import java.util.Map;
/**
 * 利用map進行整理
 * 1->1
 * 2->3
 * 3->2
 * 5->1
 * 7->1
 * 
 * 對map 迭代, 找(key-1,key ) & ( key, key+1) 的總和比大小 , 迭代找出最大的即可
 * O(n) 
 * @author brian
 *
 */
public class LongestHarmoniousSubsequence {
	public static int findLHS(int[] nums) {
		int count=0;
		int result=0;
		int high=0; 
		int low=0;
		Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < nums.length ; i++){
			if(!numsMap.containsKey(nums[i])){
				numsMap.put(nums[i], 1);
			}else{
				count=numsMap.get(nums[i]);
				numsMap.put(nums[i], ++count);
			}
		}
		for(Integer i : numsMap.keySet()){
			if(numsMap.containsKey(i+1)){
				low = numsMap.get(i)+numsMap.get(i+1);
			}
			if(numsMap.containsKey(i-1)){
				high = numsMap.get(i-1)+numsMap.get(i);
			}
			result=Math.max(result,Math.max(low, high));
			low=0;
			high=0;
		}
		return result;
    }
	 public static void main(String[] args){
		 int[] nums={1,3,2,2,5,2,3,7};
		 findLHS(nums);
	 }
}
