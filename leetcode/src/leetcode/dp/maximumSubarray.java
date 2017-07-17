package leetcode.dp;

public class maximumSubarray {
	public static int maxSubArray(int[] nums) {
		int previousNumber=0;
		int curNumber=0;
		int i=0;
		int j=0;
		int curMax=nums[0];
		while(i<nums.length){
			curNumber=previousNumber+nums[j];
			previousNumber=curNumber;
			if(curNumber>curMax){
				curMax=curNumber;
			}
			j++;
			if(j==nums.length){
				i++;
				j=i;
				previousNumber=0;
				curNumber=0;
			}
		}
		return curMax;
    }
	public static void main(String[] args){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		maxSubArray(nums);
	}
}
