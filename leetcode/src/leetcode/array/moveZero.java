package leetcode.array;

public class moveZero {
	public static void moveZeroes(int[] nums) {
        int i=0;
        int oldNumber;
		for(int j =0 ; j < nums.length ; j++){
        	if(nums[j]==0){
        		continue;
        	}
        	oldNumber=nums[i];
        	nums[i]=nums[j];
        	nums[j]=oldNumber;
        	i++;
        }
    }
	public static void main(String[] args){
		int[] nums={2, 5, 0, 7, 12};
		moveZeroes(nums);
	}
}
