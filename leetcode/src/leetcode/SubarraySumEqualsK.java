package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 小心邊界, 負號, 這種測資{0,0,0},0!!!
 * 思路1: 用slide window-->條件過於複雜, 有負號
 * 思路2: 累加數列並把數存入map統計, 只要當下的nums[i]=k, 計數器+1, 若不相等, nums[i]-k並比對map裡面的key, 相等的話即把計數器+value,不相等繼續運算(差一個測資{0,0,0},0)
 * 思路3: 改為 比對完sum之後, 再繼續比對map裡面的key即可accept, 而不是不相等才比對
 * 
 * @author brian
 *
 */
public class SubarraySumEqualsK {
	public static int subarraySum(int[] nums, int k) {
		Map<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
		int sum=0;
		int count=0;
		int number;
		for(int i =0 ; i < nums.length ; i++){
			sum = sum+nums[i];
			if(sum==k){
				count++;
			}
			if(sumMap.containsKey(sum-k)){
				count=count+sumMap.get(sum-k);
			}
			if(sumMap.containsKey(sum)){
				number = sumMap.get(sum);
				sumMap.put(sum, ++number);
			}else{
				sumMap.put(sum, 1);
			}
		}
		return count;
    }
	public static void main(String[] args){
    	int [] nums= {0,0,0};
    	subarraySum(nums,0);
    }
}
//int i = 0 ; 
//int j = 0 ;
//int sum;
//int count=0;
//if(nums==null){
//	return 0;
//}
//sum=nums[j];
//while(i<=j&&j<nums.length){
//	if(sum==k||(j==nums.length-1&&sum!=k)){
//		if(sum==k){
//			count++;
//		}
//		sum=sum-nums[i];
//		i++;
//	}else{
//			if(j<nums.length-1){
//				j++;
//				sum=sum+nums[j];
//			}
//	}
//}
//return count;