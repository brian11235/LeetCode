package leetcode.DFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/**
 * 
 * 思路1: 用bfs取每一層的值相加, 然後再用houseRobber one 的方法來計算最大值(錯誤),  2
 * 																																							/     \           最大值為3+4 =7, 而不是隔層去算最大值
 *                                                                                                                                                             1     3
 *                                                                                                                                                              \                
 *                                                                                                                                                              4
 * 
 * @author brian
 *
 */

public class HouseRobberIII {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static int rob(TreeNode root) {
		Map<TreeNode, Integer> dpMap = new HashMap<TreeNode, Integer>();
		return countMax(root,dpMap);
    }
	public static int countMax(TreeNode root, Map<TreeNode, Integer> dpMap){
		int val = 0;
		int max;
		if (root == null){
			return 0;
		}
	    if(dpMap.containsKey(root)){
	    	return dpMap.get(root); 
	    }
	    
	    if (root.left != null) {
	        val += rob(root.left.left) + rob(root.left.right);
	    }
	    
	    if (root.right != null) {
	        val += rob(root.right.left) + rob(root.right.right);
	    }
	    max = Math.max(val + root.val, rob(root.left) + rob(root.right));
	    dpMap.put(root, max);
	    return max;
	}
	public static void main(String[] args){
		 TreeNode root = new TreeNode(4);
		 TreeNode left = new TreeNode(1);
		 TreeNode right = new TreeNode(2);
		 TreeNode a = new TreeNode(3);
		 root.left=left;
		 left.left=right;
		 right.left=a;
		 int ab = rob(root);
		 System.out.println(ab);
	}
}
//int preLevelCount=1;
//int level =1; 
//int sum=0;
//int preMax=0;
//int curMax=0;
//int tempValue;
//Queue<TreeNode> queue = new LinkedList<TreeNode>();
//TreeNode tempRoot;
//queue.offer(root);
//while(root!=null&&queue.size()!=0){
//	tempRoot = queue.poll();
//	sum = sum+tempRoot.val;
//	preLevelCount--;
//	if(tempRoot.left!=null){
//		queue.offer(tempRoot.left);
//	}
//	if(tempRoot.right!=null){
//		queue.offer(tempRoot.right);
//	}
//	if(preLevelCount==0){
//		if(level==1){
//			preMax=0;
//			curMax = sum;
//		}else if(level==2){
//			preMax=curMax;
//			curMax = Math.max(sum, curMax);
//		}else{
//			if(preMax+sum > curMax){
//				tempValue=preMax;
//				preMax = curMax;
//				curMax = tempValue+sum;
//			}else{
//				preMax = curMax;
//			}
//		}
//		preLevelCount=queue.size();
//		sum=0;
//		level++;
//	}
//}
//return Math.max(curMax, preMax);
