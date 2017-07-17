package leetcode.dp;

import java.util.ArrayList;
import java.util.List;


public class MaximumProductSubarray {
	 public static int maxProduct(int[] nums) {
		 int previousMax = 1;
		 int min=1;
		 if(nums.length==1){
			 return nums[0];
		 }
		 int max=1;
		 for(int i = 0 ; i < nums.length ; i ++){
			 if(nums[i]<0){
				 
				 
				 
			 }
		 }
		 return max;   
	  }
	 
	 public static void main(String[] args){
		 	 //-2,0,-3
			int [] nums = {2,3,-2,4};
			maxProduct(nums);
	}
}
//if(nums[i]==0){
//	 lastMax = Math.max(lastMax,max);
//	 max=1;
//	 continue;
//}
