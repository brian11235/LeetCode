package leetcode.array;
/**
 * ->應該有更好的辦法
 * 
 * 從左右去算
 * ex: 2, 6, 4, 8, 10, 9, 15
 * 
 * low : 最左邊的值
 * high: 最右邊的值
 * 從low開始迭代,只要遇到<low的數 記起來(fixLow), 若無, low+1
 * 在從high 反向迭代, 只要遇到>high 的數 記起來(fixHigh) , 若無 , high-1
 *  fixHigh-fixLow=result 
 * 
 * 
 * @author brian
 *
 */
public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
    	int low = 0;
    	int high= nums.length-1;
    	int a;
    	int b;
    	int fixLow=-1;
    	int fixHigh=-1;
    	int result=0;
    	if(nums==null||nums.length==0||nums.length==1){
    		return 0;
    	}
    	while(low<=high){
    		a = low +1 ;
    		b =high-1;
    		while(fixLow==-1&&a<nums.length){
    				if(nums[low]>nums[a]){
    					fixLow=low;
    					break;
    				}
    				if(a==nums.length-1){
    					low++;
    				}
    				a++;
    		}
    		while(fixHigh==-1&&b>=0){
				if(nums[high]<nums[b]){
					fixHigh=high;
					break;
				}
				if(b==0){
					high--;
				}
				b--;
    		}
    		if(fixLow!=-1&&fixHigh!=-1){
    			result=fixHigh-fixLow+1;
    			break;
    		}
    	}
		return result;
    }
    public static void main(String[] args){
    	int [] nums={4, 6, 2, 8, 10, 9, 15};
    	findUnsortedSubarray(nums);
    }
}
