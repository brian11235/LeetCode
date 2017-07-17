package leetcode.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 思路1: 用BFS,    
 * 	   1
         / \
        3   2
       / \   \  
      5   3   9 
 * ---->132539這樣的順序去讀,然後比較每一行輸出的大小(需要紀錄每一行的個數)
 * 
 * 
 * 思路2: 用DFS做
 * 
 * 
 * 
 * 
 * @author brian
 *
 */
public class FindLargestValueinEachTreeRow {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	public static List<Integer> largestValues(TreeNode root) {
		TreeNode temp;
		TreeNode right;
		TreeNode left;
		List<Integer> maxList = new ArrayList<Integer>();
		int levelNumber=1;
		int max = -1;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		if(root==null){
			return maxList;
		}
		while(queue.size()!=0){
			temp = queue.poll();
			if(max==-1){
				max=temp.val;
			}else{
				max=Math.max(temp.val, max);
			}
			levelNumber--;
			if(temp.left!=null){
				left = temp.left;
				queue.add(left);
			}
			if(temp.right!=null){
				right = temp.right;
				queue.add(right);
			}
			if(levelNumber==0){
				levelNumber=queue.size();
				maxList.add(max);
				max=-1;
			}
		}
		return maxList;
    }
	public static void main(String[] args){
		 TreeNode root = new TreeNode(1);
		 TreeNode left = new TreeNode(3);
		 TreeNode right = new TreeNode(2);
		 TreeNode a = new TreeNode(5);
		 TreeNode b = new TreeNode(3);
		 TreeNode c = new TreeNode(9);
		 root.left=left;
		 root.right=right;
		 left.left=a;
		 left.right=b;
		 right.right=c;
		 largestValues(root);
	}
}
