package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.tree.invertBinaryTree.TreeNode;

public class binaryTreePaths {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { 
	    	  val = x; 
	      }
	}
	 public static List<String> binaryTreePaths(TreeNode root) {
		    List<String> resultList = new ArrayList<String>();
		    if(root==null){
		    	return null;
		    }
		    findPath(root,String.valueOf(root.val),resultList);
	        return resultList;
	    }

	    private static void findPath(TreeNode root,String str,List<String> resultList) {
	    	if(root.left!=null){
	    		findPath(root.left,str+"->"+root.left.val,resultList);
	    	}
	    	if(root.right!=null){
	    		findPath(root.right,str+"->"+root.right.val,resultList);
	    	}
	    	if(root.left==null&&root.right==null){
	    		resultList.add(str);
	    	}
	    	if(str.contains("->")){
	    		str=str.substring(0,str.lastIndexOf("->"));
	    	}
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
		 binaryTreePaths(root);
	}
}
//Queue<TreeNode> rootQueue = new LinkedList<TreeNode>();
//String left;
//String right;
//if(root == null){
//	 return null;
//}
//rootQueue.offer(root);
//while(rootQueue!=null){
//	 TreeNode bufferNode=rootQueue.poll();
//	 if(root.left!=null){
//		 rootQueue.offer(root.left);
//	 }
//	 if(root.right!=null){
//		 rootQueue.offer(root.right);
//	 }
//}
