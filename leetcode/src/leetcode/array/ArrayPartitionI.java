package leetcode.array;

/**
 * 題目: 將一個數列拆成2個2個一組,取這2個中比較小的那個, 加在一起(越大越好)
 * 
 * 簡單, 重點是要熟悉quickSort
 * @author brian
 *
 */
public class ArrayPartitionI {
    public static int arrayPairSum(int[] nums) {
    	int count=0;
    	nums=quickSort(nums,0,nums.length-1);
    	for(int i=0 ; i < nums.length ; i+=2){
    		count = count + nums[i]; 
    	}
		return count;
    }
    public static int[] quickSort(int [] nums, int low, int high){
		int pivet;
		int i;
		int j;
		int temp;
    	if(nums==null||nums.length == 0){
			return nums;
		}
    	pivet=nums[low];
    	i =low+1;
    	j=high;
    	if(low>=high){
    		return nums;
    	}
    	while(i<=j){
    		while(i<nums.length&&nums[i]<pivet){
    			i++;
    		}
    		while(j<nums.length&&nums[j]>pivet){
    			j--;
    		}
    		if(i<=j){
    			temp=nums[i];
    			nums[i]=nums[j];
    			nums[j]=temp;
    			i++;
    			j--;
    		}
    	}
    	temp=nums[j];
    	nums[j]=nums[low];
    	nums[low]=temp;
    	if(j>low){
    		quickSort(nums,low,j-1);
    	}
    	if(i<high){
    		quickSort(nums,i,high);
    	}
    	return nums;
    }
    public static void main(String[] args){
    	int[] nums = {1,1};
    	arrayPairSum(nums);
    }
}
