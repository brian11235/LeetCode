package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.tree.pathSum.TreeNode;

public class minimumDepthofBinaryTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public static int minDepth(TreeNode root) {
		List<Integer> mindepthLenList = new ArrayList<Integer>(); 
		int curMinDepth=1;
		if(root == null){
			return 0;
		}
		mindepthLenList=countDepth(root,curMinDepth,mindepthLenList);
		for(int a : mindepthLenList){
			if(curMinDepth==1){
				curMinDepth=a;
			}
			if(curMinDepth>a){
				curMinDepth=a;
			}
		}
		return curMinDepth;
    }
	public static List countDepth(TreeNode root, int curMinDepth,List<Integer> mindepthLen){
		if(root.left!=null){
			curMinDepth++;
			countDepth(root.left,curMinDepth,mindepthLen);
			curMinDepth--;
		}
		if(root.right!=null){
			curMinDepth++;
			countDepth(root.right,curMinDepth,mindepthLen);
		}
		if(root.left==null&&root.right==null){
			mindepthLen.add(curMinDepth);
		}
		return mindepthLen;
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		 TreeNode left = new TreeNode(2);
		 TreeNode right = new TreeNode(2);
		 TreeNode a = new TreeNode(3);
		// TreeNode b = new TreeNode(4);
		 TreeNode c = new TreeNode(4);
		 TreeNode d = new TreeNode(3);
		 TreeNode e = new TreeNode(5);
		 TreeNode f = new TreeNode(6);
		 TreeNode g = new TreeNode(1);
		 TreeNode h = new TreeNode(2);
		 TreeNode i = new TreeNode(2);
		 TreeNode j = new TreeNode(1);
		// TreeNode k = new TreeNode(6);
		 //TreeNode l = new TreeNode(5);
		 root.left=left;
		 root.right=right;
		 left.left=a;
		 a.left=e;
		a.right=f;		 
		// left.right=b;
		// b.left=g;
		// b.right=h;
		 right.left=c;
		 c.left=i;
		 c.right=j;
		 right.right=d;
		 //d.left=k;
		 //d.right=l;
		 minDepth(root);
	}
}
