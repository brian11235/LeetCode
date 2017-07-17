package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.tree.maximumDepthOfBinaryTree.TreeNode;
/**
 * 
 * 思路1: BFS, 最後array reverse即可(應該可以有更好的方法)
 * 
 * 
 * 
 * @author brian
 *
 */
public class binaryTreeLevelOrderTraversal2 {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		List<Integer> rowList = new ArrayList<Integer>();
		List<List<Integer>> reverseResultList = new ArrayList<List<Integer>>();
		int nextLevel =2;
		int curLevel=1;
		int count=0;
		if(root==null){
			return null;
		}
		Queue<TreeNode> qtree = new LinkedList<TreeNode>();
		qtree.offer(root);
		while(!qtree.isEmpty()){
			TreeNode temp=qtree.poll();
			rowList.add(temp.val);
			if(temp.left!=null){
				qtree.offer(temp.left);
				count++;
			}
			if(temp.right!=null){
				qtree.offer(temp.right);
				count++;
			}
			if(rowList.size()==curLevel){
				resultList.add(rowList);
				rowList=new ArrayList<Integer>();	
				curLevel=count;
				count=0;
			}
		}
		for(int i = resultList.size()-1 ; i >= 0 ; i--){
            reverseResultList.add(resultList.get(i));
        }
		return reverseResultList;
	}
//	public static List<Integer>countRow(TreeNode root,List<Integer> rowList){
//		if(root.left==null){
//			
//		}
//		
//		
//		return rowList;	
//	}
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
		 levelOrderBottom(root);
	}
//	List<List<Integer>> res = new ArrayList<List<Integer>>();  
//    if(root == null)  
//        return res;  
//    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
//    int lastNum = 1;  
//    int curNum = 0;  
//    int level = 0;  
//    queue.add(root);  
//    while(!queue.isEmpty())  
//    {  
//        TreeNode n = queue.pop();  
//        if(res.size()<=level)  
//            res.add(new ArrayList<Integer>());  
//        res.get(level).add(n.val);  
//        lastNum--;  
//        if(n.left!=null)  
//        {  
//            queue.add(n.left);  
//            curNum++;  
//        }  
//        if(n.right!=null)  
//        {  
//            queue.add(n.right);  
//            curNum++;  
//        }  
//        if(lastNum==0)  
//        {  
//            level++;  
//            lastNum = curNum;  
//            curNum = 0;  
//              
//        }  
//    }  
//    Collections.reverse(res);  
//    return res;  
//}
}
