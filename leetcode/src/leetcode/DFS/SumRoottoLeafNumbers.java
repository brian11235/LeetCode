package leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路1: 用DFS搜索各節點(轉成String相加), 找到底node, 放到array裡面, DFS結束後, 再把array裡的數轉為Integer相加即可 
 * 
 * 
 * @author brian
 *
 */
public class SumRoottoLeafNumbers {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public static int sumNumbers(TreeNode root) {
        int sum=0;
        sum=constructTree(root,sum);
		return sum;
    }
	public static int constructTree(TreeNode root,int sum){
		if(root == null){
			return 0;
		}
		if(root.left==null && root.right ==null){
			return sum+root.val;
		}
		int baseSum = (sum+root.val)*10;
		int leftValue = constructTree(root.left,baseSum);
		int rightValue = constructTree(root.right,baseSum);
		return leftValue+rightValue;
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
		 sumNumbers(root);
	}
}
//思路1如下:
//public static int sumNumbers(TreeNode root) {
//    List<String> nodeList = new ArrayList<String>();
//    int res=0;
//    if(root!=null){
//    	 String route =String.valueOf(root.val);
//         nodeList= constructTree(nodeList,root,route);
//    }
//    for(String str : nodeList){
//    	res = res+Integer.parseInt(str);
//    }
//	return res;
//}
//public static List<String> constructTree(List<String> nodeList,TreeNode root,String route){
//	if(root.left!=null){
//		 route=route+String.valueOf(root.left.val);
//		 constructTree(nodeList,root.left,route);
//		 route=route.substring(0, route.length()-1);
//	}
//	if(root.right!=null){
//		route=route+String.valueOf(root.right.val);
//		constructTree(nodeList,root.right,route);
//		route=route.substring(0, route.length()-1);
//	}
//	if(root.left==null&&root.right==null){
//		nodeList.add(route);
//	}
//	
//	return nodeList;
//}