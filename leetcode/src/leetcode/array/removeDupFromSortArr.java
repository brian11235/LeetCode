package leetcode.array;

public class removeDupFromSortArr {
	public static int removeDuplicates(int[] nums) {
		int i =0;
		if (nums.length < 2){
			return nums.length;
		}
		for(int j=1;j<nums.length;j++){
			if(nums[i]!=nums[j]){
				i++;
				nums[i]= nums[j];
			}
		}
		return i+1;
    }
	public static void main(String[] args){
		int[] nums={1,2,2,3,3};
		removeDuplicates(nums);
	}
}
