package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*****
 * buttom up : 每次運算把差值算完後, 把左右子點加到root遞迴繼續運算
 * 可以改進不需要用List
 * @author brian
 *
 */
public class binaryTreeTilt {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public static int findTilt(TreeNode root) {
		List<Integer> tiltList = new ArrayList<Integer>();
		int sumTilt = 0; 
		if(root==null){
			return 0;
		}
		tiltList=countTilt(root,tiltList);
		for(int tilt: tiltList){
			sumTilt=sumTilt+tilt;
		}
		return sumTilt;
    }
	public static List countTilt(TreeNode root, List<Integer> tiltList){
		if(root.left!=null){
			countTilt(root.left,tiltList);
		}
		if(root.right!=null){
			countTilt(root.right,tiltList);
		}
		if(root.left!=null||root.right!=null){
			if(root.right==null){
				root.right=new TreeNode(0);
			}
			if(root.left==null){
				root.left=new TreeNode(0);
			}
			tiltList.add(Math.abs(root.right.val-root.left.val));
			root.val=root.val+root.left.val+root.right.val;
		}
		return tiltList;
	}
	public static void main(String[] args){
		 TreeNode root = new TreeNode(4);
		 TreeNode left = new TreeNode(2);
		 TreeNode right = new TreeNode(7);
		 //TreeNode a = new TreeNode(1);
		 TreeNode b = new TreeNode(3);
		 TreeNode c = new TreeNode(6);
		 TreeNode d = new TreeNode(9);
		 root.left=left;
		 root.right=right;
		 //left.left=a;
		 left.left=b;
		 left.right=c;
		 right.left=d;
		 findTilt(root);
	}
}
