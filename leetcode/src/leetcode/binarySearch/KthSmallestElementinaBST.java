package leetcode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.tree.minimumDepthofBinaryTree.TreeNode;
/**
 * 思路1: (recursive)inorder sort找答案即可
 * 思路2: (iteration)
 * @author brian
 *
 */
public class KthSmallestElementinaBST {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	public static int kthSmallest(TreeNode root, int k) {
		List<Integer> valueList = new ArrayList<Integer>();
		return getTreeValue(root,valueList).get(k-1);
    }
	public static List<Integer> getTreeValue(TreeNode root, List<Integer> valueList){
		if(root.left!=null){
			getTreeValue(root.left,valueList);
		}
		valueList.add(root.val);
		if(root.right!=null){
			getTreeValue(root.right,valueList);
		}
		return valueList;
	}
	public static void main(String[] args){
		 TreeNode root = new TreeNode(1);
//		 TreeNode left = new TreeNode(4);
		 TreeNode right = new TreeNode(2);
//		 TreeNode a = new TreeNode(1);
//		 TreeNode c = new TreeNode(5);
//		 TreeNode d = new TreeNode(7);
//		 TreeNode e = new TreeNode(9);
//		 root.left=left;
		 root.right=right;
//		 left.left=a;
//		 left.right=c;
//		 right.left=d;
//		 right.right=e;
		 kthSmallest(root,2);
	}
}
//if(root.left!=null){
//getTreeValue(root.left,k,valueList);
//}
//if(root.right!=null){
//getTreeValue(root.right,k,valueList);
//}
//if(root.left!=null||root.right!=null){
//
//}