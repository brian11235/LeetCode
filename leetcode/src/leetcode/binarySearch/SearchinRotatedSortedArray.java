package leetcode.binarySearch;
/**
 * 思路1: 直接迭代找, O(n)
 * 
 * 思路2: 用BS試看看
 * 			 因為數列只有部分排序, 每一次迭代中, mid 跟 j 做比較, 若mid > j, 0->mid的數組是正確排序的, 檢查target是否在裡面, 若是則繼續檢查, 若否則檢查mid+1->j
 *                                                                                                                若 mid < j , mid->j的數組是正確排序的, 檢查target是否在裡面, 若是則繼續檢查, 若否則檢查0->mid-1
 * @author brian
 *
 */
public class SearchinRotatedSortedArray {
	 public static int search(int[] nums, int target) {
		 int i = 0; 
		 int j = nums.length-1;
		 int mid;
		 while(i<=j){
			 mid= (i+j)/2;
			 if(nums[mid]==target){
				 return mid;
			 }
			 if(nums[mid]>nums[j]){
				 if(target>=nums[i]&&target<=nums[mid]){
					 j=mid-1;
				 }else{
					 i=mid+1;
				 }
			 }else{
				 if(target>=nums[mid]&&target<=nums[j]){
					 i=mid+1;
				 }else{
					 j=mid-1;
				 }
			 }
		 }
		 return -1;
	 }
	 public static void main(String[] args){
			int []nums={1,3};
			search(nums,3);
		}
}



//for(int i = 0 ; i < nums.length ; i++){
//    if(nums[i]==target){
//        return i;
//    }
//}
//return -1;