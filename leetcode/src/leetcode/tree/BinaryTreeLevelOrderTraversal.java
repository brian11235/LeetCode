package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 思路1: BFS即可
 * 思路2: 改為遞迴試看看
 * 
 * 
 * @author brian
 *
 */
public class BinaryTreeLevelOrderTraversal {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 public List<List<Integer>> levelOrder(TreeNode root) {
		int levelNumber=1;
		TreeNode tempRoot;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> levelList = new ArrayList<Integer>();
		List<List<Integer>> totalList = new ArrayList<List<Integer>>();
		queue.offer(root);
		while(root!=null&&queue.size()!=0){
			tempRoot=queue.poll();
			levelList.add(tempRoot.val);
			levelNumber--;
			if(tempRoot.left!=null){
				queue.offer(tempRoot.left);
			}
			if(tempRoot.right!=null){
				queue.offer(tempRoot.right);
			}
			if(levelNumber==0){
				levelNumber=queue.size();
				totalList.add(levelList);
				levelList = new ArrayList<Integer>();
			}
		}
		 return totalList;
	 }
}
