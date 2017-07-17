package leetcode.tree;

public class sameTree {
	   public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null){
			return true;
		}
		if(p==null||q==null){
			return false;
		}
		if(p.val!=q.val){
			return false;
		}
		return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
	public static void main(String[] args){
		 Boolean a;
		 TreeNode p = new TreeNode(0);
		 //TreeNode pLeft=new TreeNode(4);
		 //TreeNode pLight=new TreeNode(6);
		 //p.left=pLeft;
		// p.right=pLight;
		 a=isSameTree(p,p);
		 System.out.println(a);
	}
}
