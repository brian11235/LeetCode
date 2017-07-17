package leetcode.hashMap;

public class ContiguousArray {
	public static int findMaxLength(int[] nums) {
		int zeroCount=0;
		int oneCount=0;
		int maxLength = 0; 
	    if(nums==null || nums.length==0||nums.length==1){
	    	return 0;
	    }
		for(int i=0 ; i < nums.length ; i++){
			for(int j=i ; j < nums.length ; j++){
				if(nums[j]==0){
					zeroCount++;
				}else{
					oneCount++;
				}
				if(zeroCount == oneCount){
					maxLength=Math.max(maxLength, zeroCount+oneCount);
				}
			}
			zeroCount=0;
			oneCount=0;
		}
		return maxLength;
    }
	public static void main(String[] args){
		int[] nums= {0,1,0,0,0,1,0,1};
		findMaxLength(nums);
	}
	
}

//time limit 
//int zeroCount=0;
//int oneCount=0;
//int maxLength = 0; 
//if(nums==null || nums.length==0||nums.length==1){
//	return 0;
//}
//for(int i=0 ; i < nums.length ; i++){
//	for(int j=i ; j < nums.length ; j++){
//		if(nums[j]==0){
//			zeroCount++;
//		}else{
//			oneCount++;
//		}
//		if(zeroCount == oneCount){
//			maxLength=Math.max(maxLength, zeroCount+oneCount);
//		}
//	}
//	zeroCount=0;
//	oneCount=0;
//}
//return maxLength;