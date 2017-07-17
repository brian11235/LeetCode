package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class thirdMaxNumber {
	public static int thirdMax(int[] nums) {
		List<Integer> arr= new ArrayList<Integer>();
		for(int i =0; i<nums.length; i++){
			if(arr.size()>2){
				if(nums[i]>arr.get(0)&&!arr.contains(nums[i])){
					arr.set(0, nums[i]);
					arr=sort(arr);
				}
			}else{
				if(!arr.contains(nums[i])){
					arr.add(nums[i]);
					arr=sort(arr);
				}
			}
		}
		if(arr.size()==2){
			return arr.get(1);
		}else{
			return arr.get(0);
		}
	}
	public static List<Integer> sort(List<Integer> arr){
		List<Integer> sortArr = new ArrayList<Integer>();
		sortArr.add(arr.get(0));
		int original = 0;
		for(int i=1; i< arr.size(); i++){
			sortArr.add(arr.get(i));
			for(int j=sortArr.size()-1;j>0;j--){
				if(sortArr.get(j-1)>sortArr.get(j)){
					original = sortArr.get(j);
					sortArr.set(j, sortArr.get(j-1));
					sortArr.set(j-1, original);
				}
			}
		}
		return sortArr;
	}
	public static void main(String[] args){
		//int[] nums={4,3,2,7,8,2,3,1};
		//int[] nums={2, 2, 3, 1};
		int[] nums={1, 2};
		thirdMax(nums);
	}
}
