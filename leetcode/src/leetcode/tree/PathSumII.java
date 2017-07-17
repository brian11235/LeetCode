package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.tree.balancedBinaryTree.TreeNode;

public class PathSumII {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<Integer> pathList = new ArrayList<Integer>();

		
		return null;
    }
	public List<Integer> countPathSum(TreeNode root, int sum,List<Integer> pathList){
		int total=0;
		if(root.left!=null){
			total = total + root.left.val;
		}
		if(root.right!=null){
			total = total + root.right.val;
		}
		
		
		return pathList;
	}
}
