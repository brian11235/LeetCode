package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.tree.minimumDepthofBinaryTree.TreeNode;

public class balancedBinaryTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public static boolean isBalanced(TreeNode root) {
		countDepth(root);
		return true;
		
    }
	public static int countDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		int leftHeight =  countDepth(root.left);
		int rightHeight = countDepth(root.right);
		
		if(Math.abs(leftHeight - rightHeight)>1){
			return -1;
		}
		return Math.max(leftHeight, rightHeight)+1;
	}
	public static void main(String[] args){
		 TreeNode root = new TreeNode(1);
		 TreeNode left = new TreeNode(2);
		 TreeNode right = new TreeNode(2);
		 TreeNode a = new TreeNode(3);
		 TreeNode b = new TreeNode(4);
		 TreeNode c = new TreeNode(4);
		 TreeNode d = new TreeNode(3);
		 TreeNode e = new TreeNode(5);
		 TreeNode f = new TreeNode(6);
		 root.left=left;
		 root.right=right;
		 left.left=a;
		 left.right=b;
		 a.left=c;
		 a.right=d;
		 d.left=e;
		 right.left=f;
		 isBalanced(root);
	}
}
