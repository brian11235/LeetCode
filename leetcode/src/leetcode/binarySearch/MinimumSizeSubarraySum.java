package leetcode.binarySearch;
/**
 * 思路1: 垃圾解法, 直接暴力算 
 * 思路2: 雙指針, O(n), slide window, i,j先指到nums[0], 只要當下sum<s, 就右移動右指針j直到 sum>s,計算最小區間並且比較,再右移動左指針i一格, 重覆此動作就可以找到最小區間
 * @author brian
 *
 */
public class MinimumSizeSubarraySum {
	public static int minSubArrayLen(int s, int[] nums) {
		int i = 0 ; 
		int j = 0; 
		int min=nums.length+1;
		if(nums==null||nums.length==0){
			return 0;
		}
		int sum=nums[0];
		while(i<=j && j < nums.length){
			if(sum<s){
				j++;
				if(j!=nums.length){
					sum=sum+nums[j];
				}
			}else{
				min=Math.min(min, j-i+1);
				sum=sum-nums[i];
				i++;
			}
		}
		return min==nums.length+1 ? 0:min;
    }
	public static void main(String[] args){
		int [] nums={1,1};
		minSubArrayLen(3,nums);
	}
}
//int sum=0;
//int minlength=0;
//for(int i = 0 ; i < nums.length ; i++){
//	for(int j= i; j<nums.length ; j++){
//		sum=sum+nums[j];
//		if(sum>=s){
//			if(minlength==0){
//				minlength=j-i+1;
//			}else{
//				minlength=Math.min(minlength, j-i+1);
//			}
//			sum=0;
//			break;
//		}
//		sum=0;
//	}
//}
//return minlength;


//sum=sum+nums[j];
//if(sum>=s){
//	if(min == 0){
//		min=j-i+1;
//	}else{
//		min=Math.min(min, j-i+1);
//	}
//	sum=sum-nums[i];
//	i++;
//}else{
//	if(j!=nums.length-1){
//		j++;
//	}
//}