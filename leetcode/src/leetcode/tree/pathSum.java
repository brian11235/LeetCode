package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.tree.binaryTreeLevelOrderTraversal2.TreeNode;

public class pathSum {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 public static boolean hasPathSum(TreeNode root, int sum) {
		 List<Integer> sumList = new ArrayList<Integer>();
		 boolean pathSum;
		 if(root==null){
			 return false;
		 }
		 int count=root.val;
		 sumList=countSum(root,count,sumList);
		 if(sumList.contains(sum)){
			 return true;
		 }
		return false;  
	  }
	 public static List countSum(TreeNode root,int count,List<Integer> sumList){
		int lastCount;
		if(root.left!=null){
			count=count+root.left.val;
			countSum(root.left,count,sumList);
		}
		if(root.right!=null){
			if(root.left!=null){
				count = count-root.left.val;
			}
			count= count+root.right.val;
			countSum(root.right,count,sumList);
		}
		if(root.left==null&&root.right==null){
			sumList.add(count);
		}
		 return sumList;
		 
	 }
	 public static void main(String[] args){
		 TreeNode root = new TreeNode(1);
		 TreeNode left = new TreeNode(2);
		 TreeNode right = new TreeNode(2);
		 TreeNode a = new TreeNode(3);
		// TreeNode b = new TreeNode(4);
		 TreeNode c = new TreeNode(4);
		 TreeNode d = new TreeNode(3);
		 TreeNode e = new TreeNode(5);
		 TreeNode f = new TreeNode(6);
		 TreeNode g = new TreeNode(1);
		 TreeNode h = new TreeNode(2);
		 TreeNode i = new TreeNode(2);
		 TreeNode j = new TreeNode(1);
		// TreeNode k = new TreeNode(6);
		 //TreeNode l = new TreeNode(5);
		 root.left=left;
		 root.right=right;
		 left.left=a;
		 a.left=e;
		a.right=f;		 
		// left.right=b;
		// b.left=g;
		// b.right=h;
		 right.left=c;
		 c.left=i;
		 c.right=j;
		 right.right=d;
		 //d.left=k;
		 //d.right=l;
		 hasPathSum(root,8);
	 }
}
