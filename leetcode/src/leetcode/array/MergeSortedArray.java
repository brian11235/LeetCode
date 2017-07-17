package leetcode.array;

public class MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=0;
		int j=0;
		int previousNums2InNums1=0;
		for(i=m ; i < nums1.length ; i++){
	        nums1[i]=nums2[j];
	        j++;
	     }
		if(m!=0){
			j=m;
			i=0;
			while(j<nums1.length){
				if(nums1[j]<nums1[i]){
					int temp = nums1[i];
					nums1[i]=nums1[j];
					nums1[j]=temp;
				}
				i++;
				if(i==j){
					j++;
					i=0;
				}
			}
		}
    }
	public static void main(String[] args){
//		int[] nums1={1,3,5,6,7,10,0,0};
//		int[] nums2={2,9};
//		merge(nums1,6,nums2,2);
		int[] nums1={0};
		int[] nums2={1};
		merge(nums1,0,nums2,1);
		
	}
}
