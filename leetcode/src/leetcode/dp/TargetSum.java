package leetcode.dp;
/**
 * 
 * 用DFS搜尋, 速度很慢須改進
 * 
 * 
 * @author brian
 *
 */
public class TargetSum {
	public static int findTargetSumWays(int[] nums, int S) {
		int level=0;
		int result=0;
		int sum=0;
		result=findSum(nums,S,level,result,sum);
		return result;
    }
	public static int findSum(int [] nums, int S, int level,int result,int sum){
		if(level<nums.length){
			sum=sum-nums[level];
			level++;
			result=findSum(nums,S,level,result,sum);
			level--;
			sum=sum+nums[level];
		}
		if(level<nums.length){
			sum=sum+nums[level];
			level++;		
			result=findSum(nums,S,level,result,sum);
			level--;
			sum=sum-nums[level];
		}
		if(level==nums.length){
			if(sum==S){
				result++;
			}
		}
		return result;
	}
	public static void main(String[] args){
    	int [] nums= {1,0};
    	findTargetSumWays(nums,-1);
    }
}
