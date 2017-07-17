package leetcode.dp;

import java.util.HashMap;
import java.util.Map;
/****
 * 先把index算完,然後再加
 * @author brian
 *
 */
public class RangeSumQueryImmutable {
	int result=0;
	int [] indexArr;
	Map<Integer,Integer> resultMap = new HashMap<Integer,Integer>();
	public RangeSumQueryImmutable(int[] nums) {
        indexArr=nums;
    }
    public int sumRange(int i, int j) {
    	if(resultMap.isEmpty()){
    		for(int k= 0 ; k < indexArr.length ; k ++){
    			result = result+indexArr[k];
    			resultMap.put(k, result);
    		}
    	}
    	if(i==0){
    		return resultMap.get(j);
    	}
		return resultMap.get(j)-resultMap.get(i-1); 
    }
    public static void main(String[] args){
    	int[] nums={-2, 0, 3, -5, 2, -1};
    	RangeSumQueryImmutable ri = new RangeSumQueryImmutable(nums);
    	int index = ri.sumRange(2, 5);
    	int index1 = ri.sumRange(0, 3);
    	int index2 = ri.sumRange(0, 5);
    }
}
//NON-DP 很慢
//int result=0;
//int [] indexArr;
//public NumArray(int[] nums) {
//    indexArr=nums;
//}
//
//public int sumRange(int i, int j) {
//    result=0;
//	while(i<=j){
//		result=result+indexArr[i];
//		i++;
//	}
//	return result; 

