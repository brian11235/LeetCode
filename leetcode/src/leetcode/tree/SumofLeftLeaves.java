package leetcode.tree;

/**
 * 思路1: 用DFS遞迴, 條件是左子樹不為空且左子樹的左右都要為空
 * 		3(左子樹不為空)
 *        / 
 *      4(左右為空)
 *  
 * @author brian
 *
 */
public class SumofLeftLeaves {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public static int sumOfLeftLeaves(TreeNode root) {
		int leftSum=0;
		if(root==null){
            return 0;
        }
		return countSum(root,leftSum);
    }
	public static int countSum(TreeNode root, int leftSum){
		if(root.left!=null){
			leftSum=countSum(root.left,leftSum);
		}
		if(root.right!=null){
			leftSum=countSum(root.right,leftSum);
		}
		if(root.left!=null&&root.left.left==null&&root.left.right==null){
			leftSum = leftSum+root.left.val;
		}
		return leftSum;
	}
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
		 sumOfLeftLeaves(root);
	}
}
