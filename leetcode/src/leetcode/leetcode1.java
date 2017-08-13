package leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * Two Sum
 * 思路：跑一個for迭代,每次都檢查map,只要map裡面存在target-nums[]的值,直接return, 若無,把這組值存放到map裡面
 * 
 * 
 * @author linbrian
 *
 */
public class leetcode1 {
//	public static int[] twoSum(int[] nums, int target) {
//		int total;
//		int[] totalArray= new int[2];
//		int i,j;
//		int index;
//		for(i=0; i< nums.length; i++){
//			for(j=i+1; j<nums.length; j++){
//				total= nums[i]+nums[j];
//				if(total != target){
//					continue;
//				}else{
//					totalArray[0]=i;
//					totalArray[1]=j;
//					return totalArray;
//				}
//			}
//		}
//		return null;
//	}
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        if (map.containsKey(target - nums[i])) {
	            result[1] = i;
	            result[0] = map.get(target - nums[i]);
	            return result;
	        }
	        map.put(nums[i], i);
	    }
		return result;
	}
	
	 public static void main(String[] args) {
		 int[] nums = {2,7,11,15,17};
		 int target = 32;
		 nums=twoSum(nums, target);
		 System.out.println(nums[0]+","+nums[1]);
	 }
}
