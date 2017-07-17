package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.tree.sameTree.TreeNode;

public class isSymmetricTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public static boolean isSymmetric(TreeNode root) {
		//List liLeft = new ArrayList();
		//List liright = new ArrayList();
		if(root==null||(root.left==null&&root.right==null)){
			return true;
		}
		if(root.left==null||root.right==null){
			return false;
		}
		return checkChildern(root.left,root.right);
    }
	public static boolean checkChildern(TreeNode left,TreeNode right){
		if(left==null&&right==null){
			return true;
		}
		if(left==null||right==null){
			return false;
		}
		if(left.val==right.val){
			boolean leftcheck= checkChildern(left.left,right.right);
			boolean rightcheck= checkChildern(left.right,right.left);
			return leftcheck&&rightcheck;
		}
		
		return false;
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
		 TreeNode g = new TreeNode(1);
		 TreeNode h = new TreeNode(2);
		 TreeNode i = new TreeNode(2);
		 TreeNode j = new TreeNode(1);
		 TreeNode k = new TreeNode(6);
		 TreeNode l = new TreeNode(5);
		 root.left=left;
		 root.right=right;
		 left.left=a;
		 a.left=e;
		a.right=f;		 
		 left.right=b;
		 b.left=g;
		 b.right=h;
		 right.left=c;
		 c.left=i;
		 c.right=j;
		 right.right=d;
		 d.left=k;
		 d.right=l;
		 isSymmetric(root);
		 
	 }
}
