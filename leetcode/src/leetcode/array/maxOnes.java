package leetcode.array;

import java.util.ArrayList;
import java.util.List;

import leetcode.linkedList.DeleteLinkedList.ListNode;

public class maxOnes {
	
	
	public static int findMaxConsecutiveOnes(int[] nums) {
		int count=0;
		List<Integer> li=new ArrayList<Integer>();
		for(int i=0; i<nums.length;i++){
			if(nums[i]==0){	
				li.add(count);
				count=0;
			}else{
				count=count+1;
			}
		}
		if(count!=0){
			li.add(count);
		}
		return findMax(li);
    }
	public static int findMax(List<Integer> li){
		int index=0;
		while(li.size()!=1){
			if(li.get(index)>li.get(index+1)){
				li.remove(index+1);
			}else{
				li.remove(index);
			}
		}
		return li.get(0);
	}
	
	public static void main(String[] args){
		int[] nums={1,0,1,1,1,1,0,1,1,1};
		findMaxConsecutiveOnes(nums);
	}
}
