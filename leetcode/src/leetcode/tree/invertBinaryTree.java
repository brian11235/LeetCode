package leetcode.tree;

import leetcode.tree.minimumDepthofBinaryTree.TreeNode;
/**
 * buttom up
 * @author brian
 *
 */
public class invertBinaryTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { 
	    	  val = x; 
	      }
	}
	public static TreeNode invertTree(TreeNode root) {
		if(root == null){
			return null;
		}
		return convertTree(root);
    }
	public static TreeNode convertTree(TreeNode root){
		TreeNode bufferTree;
		if(root.left!=null){
			convertTree(root.left);
		}
		if(root.right!=null){
			convertTree(root.right);
		}
		if(root.left!=null||root.right!=null){
			bufferTree = root.left;
			root.left=root.right;
			root.right=bufferTree;
		}
		return root;
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
		 invertTree(root);
	}
	
}
