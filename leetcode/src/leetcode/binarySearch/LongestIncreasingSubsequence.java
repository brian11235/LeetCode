package leetcode.binarySearch;

public class LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
        int length=1;
        int maxlength=0;
        int temp;
        for(int i = 0 ; i < nums.length ; i++){
            temp = nums[i];
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[j]>temp){
                    length++;
                    temp = nums[j];
                }
            }
            maxlength=Math.max(maxlength,length);
            length=1;
        }
        return maxlength;
    }
	public static void main(String[] args){
		int []nums={10,9,2,5,3,4};
		lengthOfLIS(nums);
	}
}
