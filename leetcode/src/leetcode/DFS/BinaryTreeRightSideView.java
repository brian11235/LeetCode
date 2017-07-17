package leetcode.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 思路1: 用BFS找每一行最後一個數,放進array裡面即可
 * 思路2: 試試DFS
 * 
 * 
 * @author brian
 *
 */
public class BinaryTreeRightSideView {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public List<Integer> rightSideView(TreeNode root) {
		TreeNode tempRoot;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int levelNumber=1;
		List<Integer> resLi = new ArrayList<Integer>();
		queue.add(root);
		while(root!=null&&queue.size()!=0){
			tempRoot = queue.poll();
			levelNumber--;
			if(tempRoot.left!=null){
				queue.offer(tempRoot.left);
			}
			if(tempRoot.right!=null){
				queue.offer(tempRoot.right);
			}
			if(levelNumber==0){
				resLi.add(tempRoot.val);
				levelNumber=queue.size();
			}
		}
		return resLi;
        
    }
}
