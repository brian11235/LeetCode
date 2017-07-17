package leetcode.DFS;

/**
 * 
 * 思路1 :看到sortArray, 想到 BS, 再用BS的方式遞迴建樹即可
 * 
 * @author brian
 *
 */
public class ConvertSortedArraytoBinarySearchTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public static TreeNode sortedArrayToBST(int[] nums) {
		int left=0;
		int right = nums.length-1;
		TreeNode bstTree = null;
		return construcationBst(nums,left,right,bstTree);
    }
	public static TreeNode construcationBst(int [] nums, int left, int right, TreeNode bstTree){
		if(left>right){
			return null;
		}
		int mid = (left+right)/2;
		bstTree = new TreeNode(nums[mid]);
		bstTree.left = construcationBst(nums, left, mid-1, bstTree);
		bstTree.right=construcationBst(nums, mid+1,right, bstTree);
		
		return bstTree;
	}
	public static void main(String[] args){
		int [] nums = {1,2,3,5,7,9};
		sortedArrayToBST(nums);
    }
}
