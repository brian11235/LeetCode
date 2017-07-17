package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

import leetcode.tree.binaryTreePaths.TreeNode;

public class UniqueBinarySearchTrees2 {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { 
	    	  val = x; 
	      }
	}
	public static List<TreeNode> generateTrees(int n) {
		if(n==0){
	        return new ArrayList<TreeNode>();
	    }
	 
	    return helper(1, n);
    }
	public static List<TreeNode> helper(int m , int n){
		List<TreeNode> result = new ArrayList<TreeNode>();
	    if(m>n){
	        result.add(null);
	        return result;
	    }
	 
	    for(int i=m; i<=n; i++){
	        List<TreeNode> ls = helper(m, i-1);
	        List<TreeNode> rs = helper(i+1, n);
	        for(TreeNode l: ls){
	            for(TreeNode r: rs){
	                TreeNode curr = new TreeNode(i);
	                curr.left=l;
	                curr.right=r;
	                result.add(curr);
	            }
	        }
	    }
	    return result;
	}
	public static void main(String[] args){
		List<TreeNode> result = new ArrayList<TreeNode>();
		result=generateTrees(3);
	}
}
