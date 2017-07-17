package leetcode.tree;

import leetcode.tree.isSymmetricTree.TreeNode;

public class maximumDepthOfBinaryTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public static int maxDepth(TreeNode root) {
       //int countLeft=1;
        //int countRight=1;
        if(root==null){
        	return 0;
        }
        int countLeft=maxDepth(root.left);
        int countRight=maxDepth(root.right);
        return Math.max(countLeft,countRight )+1;
    }	
//	public static int countDepth(TreeNode root, int countLeft ,int countRight ){
//		
//        if(root.left!=null){
//        	countLeft=countLeft+countDepth(root.left,countLeft,countRight);
//        }
//        if(root.right!=null){
//        	countRight=countRight+countDepth(root.right,countLeft,countRight);
//        }
//        return countLeft > countRight ? countLeft : countRight;
//	}
	public static void main(String[] args){
		 TreeNode root = new TreeNode(1);
		 TreeNode left = new TreeNode(2);
		 TreeNode right = new TreeNode(2);
		 TreeNode a = new TreeNode(3);
		 TreeNode b = new TreeNode(4);
		 TreeNode c = new TreeNode(4);
		 TreeNode d = new TreeNode(3);
//		 TreeNode e = new TreeNode(5);
//		 TreeNode f = new TreeNode(6);
//		 TreeNode g = new TreeNode(1);
//		 TreeNode h = new TreeNode(2);
//		 TreeNode i = new TreeNode(2);
//		 TreeNode j = new TreeNode(1);
//		 TreeNode k = new TreeNode(6);
//		 TreeNode l = new TreeNode(5);
		 root.left=left;
		 root.right=right;
		 left.left=a;
		 //a.left=e;
		//a.right=f;		 
		 left.right=b;
		 //b.left=g;
		 //b.right=h;
		 right.left=c;
		 //c.left=i;
		 //c.right=j;
		 right.right=d;
		 //d.left=k;
		 //d.right=l;
		 int abc=maxDepth(root);
		 System.out.println(abc);
	 }
}
