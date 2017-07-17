package leetcode.binarySearch;
/**
 * 
 * 排序->binary search
 * 
 * 思路1:　用BS找到nums中的target後, 檢查target的左右, 找出target的邊界--->nums[0]會有問題
 * 
 * 
 * 
 * @author brian
 *
 */
public class SearchforaRange {
	public static int[] searchRange(int[] nums, int target) {
		
		
		
		return nums;
	}
	public static void main(String[] args){
		int []nums={1};
		searchRange(nums,1);
	}
}


//int i = 0 ; 
//int j = nums.length-1;
//int mid;
//int [] range = new int [2];
//range[0]=-1;
//range[1]=-1;
//range=findtargetRange(i, j , nums, target, range);
//return range;
//}
//public static int [] findtargetRange(int i, int j, int [] nums, int target, int [] range){
//int mid;
//while(i<=j){
//	mid = (i+j)/2;
//	if(nums[mid]>target){
//		j= mid-1;
//	}else if(nums[mid]<target){
//		i=mid+1;
//	}else{
//		if(nums[mid+1]>target&&nums[mid-1]<target){
//			range[0]=mid;
//			range[1]=mid;
//			return range;
//		}else if(nums[mid+1]>target){
//			range[1]=mid;
//			j=mid-1;
//			findtargetRange(0,j,nums,target,range);
//		}else if (mid-1>=0&&nums[mid-1]<target){
//			range[0]=mid;
//			i=mid+1;
//			findtargetRange(i,j,nums,target,range);
//		}else{
//			findtargetRange(i,mid-1,nums,target,range);
//			findtargetRange(mid+1,j,nums,target,range);
//		}
//	}
//}
//return range;