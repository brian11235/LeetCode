package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 注意重覆的輸入!!!!
 * Map 重覆紀錄會有問題    ex:(3,1)->(3,5)會蓋掉(3,1)導致後面檢查會有錯誤
 * 
 * 
 * 
 * @author brian
 *
 */
public class KdiffPairsinanArray {
	public static int findPairs(int[] nums, int k) {
		int number=0;
		int count=0;
		List<Integer> li = new ArrayList<Integer>();
		for(int i=0; i <nums.length ; i++){
			for(int j = i+1; j < nums.length ; j++){
				number = Math.abs(nums[j]-nums[i]);
				if(number == k){
					if(!(li.contains(nums[j])&&li.contains(nums[i]))){
						count++;
						li.add(nums[i]);
						li.add(nums[j]);
					}
				}
			}
		}
		return count;  
    }
	public static void main(String[] args){
		int [] nums = {3,1,3,1,5};
		
		findPairs(nums,2);
	}
}
