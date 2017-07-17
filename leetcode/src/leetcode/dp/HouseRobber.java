package leetcode.dp;

public class HouseRobber {
	public static int rob(int[] nums) {
		int max = 0;
		int previousMax = 0;
		int buffer;
		for(int i = 0 ; i < nums.length ; i++){
			if(i==0){
				max = nums[0];
			}else if(i==1){
				if(nums[1]>nums[0]){
					max=nums[1];
					previousMax=nums[0];
				}else{
					previousMax=max;
				}
			}else{
				if(previousMax+nums[i]>max){
					buffer=previousMax;
					previousMax=max;
					max=buffer+nums[i];
				}else{
					previousMax=max;
				}
				
			}
		}
		return max;  
    }
	 public static void main(String[] args){
	 	 //-2,0,-3
		int [] nums = {2,7,9,3,1};
		rob(nums);
	 }
}
