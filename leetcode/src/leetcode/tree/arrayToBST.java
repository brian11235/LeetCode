package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class arrayToBST {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { 
	    	  val = x; 
	      }
	}
	 public static TreeNode sortedArrayToBST(int[] nums) {
		 TreeNode resultTree;
		 if(nums==null||nums.length==0){
			 return null;
		 }
		 if(nums.length==1){
			 resultTree=new TreeNode(nums[0]);
			 return resultTree;
		 }
		 int first=0;
		 int last=nums.length-1;
		 return ArrToBst(first,last,nums);
	 }
	 public static TreeNode ArrToBst(int first, int last,int[] nums){
		 if(first>last){
			 return null;
		 }
		int mid=(first+last)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left=ArrToBst(first,mid-1,nums);
		root.right=ArrToBst(mid+1,last,nums);


		 return root;
	 }
	 public static void main(String[] args){
		 int[]nums1={1,2,3,4,5,6,7,8,9,10};
		 int[]nums2={55,56,88,99,100,123,134};
		 sortedArrayToBST(nums1);
		 
		 
	 }
//	public static TreeNode sortedArrayToBST(int[] num) {
//		if (num.length == 0)
//			return null;
//	    TreeNode head=sortedArrayToBST(num, 0, num.length - 1);
//		return head;
//	}
// 
//	public static TreeNode sortedArrayToBST(int[] num, int start, int end) {
//		if (start > end)
//			return null;
// 
//		int mid = (start + end) / 2;
//		TreeNode root = new TreeNode(num[mid]);
//		root.left = sortedArrayToBST(num, start, mid - 1);
//		root.right = sortedArrayToBST(num, mid + 1, end);
// 
//		return root;
//	}
}
