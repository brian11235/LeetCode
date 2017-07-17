package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路1: DFS遞迴
 * @author brian
 *
 */
public class BinaryTreeInorderTraversal {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 public static List<Integer> inorderTraversal(TreeNode root) {
		 List<Integer> inorderList = new ArrayList<Integer>(); 
		 inorderList=inorderDFS(root,inorderList);
		 return inorderList;
	 }
	 public static List<Integer> inorderDFS(TreeNode root, List<Integer> inorderList) {
		 if(root==null){
			 return inorderList;
		 }
		 inorderList=inorderDFS(root.left,inorderList);
		 inorderList.add(root.val);
		 inorderList=inorderDFS(root.right,inorderList);
		 return inorderList;
	}
	 public static void main(String[] args){
			 TreeNode root = new TreeNode(4);
			 TreeNode left = new TreeNode(2);
			 TreeNode right = new TreeNode(7);
			 TreeNode a = new TreeNode(1);
			 TreeNode b = new TreeNode(3);
			 TreeNode c = new TreeNode(6);
			 TreeNode d = new TreeNode(9);
			 root.left=left;
			 root.right=right;
			 left.left=a;
			 left.right=b;
			 right.left=c;
			 right.right=d;
			 inorderTraversal(root);
		}
}
