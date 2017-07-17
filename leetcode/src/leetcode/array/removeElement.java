package leetcode.array;

public class removeElement {
	public static int removeElement(int[] nums, int val) {
		int i=0;
		for(int j=0; j <nums.length ; j++){
			if(nums[j]==val){
				continue;
			}
			nums[i]=nums[j];
			i++;
		}
		
		return i;

    }
	public static void main(String[] args){
		//int[] nums={4,3,2,7,8,2,3,1};
		int[] nums={};
		//int[] nums={1,2,2,3,2,4};
		//int[] nums={1,2,3};
		removeElement(nums,2);
	}
}
