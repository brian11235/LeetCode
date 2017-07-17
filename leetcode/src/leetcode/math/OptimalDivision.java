package leetcode.math;
/**
 * 
 * 沒啥竅門,檢查第一個數之後,其他全部都(a/b/c)....即可
 * 
 * @author brian
 *
 */
public class OptimalDivision {
	public String optimalDivision(int[] nums) {
		StringBuffer stringNums = new StringBuffer();
        if(nums.length==1){
           return stringNums.append(nums[0]).toString();
       }
       if(nums.length==2){
           stringNums.append(nums[0]);
           stringNums.append("/");
           stringNums.append(nums[1]);
           return stringNums.toString();
       }
       stringNums.append(nums[0]);
       stringNums.append("/");
       stringNums.append("(");
       for(int i = 1 ; i < nums.length ; i ++){
           stringNums.append(nums[i]);
           if(i!=nums.length-1){
               stringNums.append("/");
           }
           
       }
       stringNums.append(")");
       return stringNums.toString();
    }
}
