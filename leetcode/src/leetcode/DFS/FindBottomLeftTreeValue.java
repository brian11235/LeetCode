package leetcode.DFS;

/**
 * 
 * 思路1: 用DFS, 把每一層的level跟最左邊的數記起來, 最後再回傳最後一層的數即可  
 * 
 * @author brian
 *
 */
public class FindBottomLeftTreeValue {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	public static int findBottomLeftValue(TreeNode root) {
		int level=1; 
		int [] levelNumber = new int[2];
		levelNumber=findLeftMost(root,level,levelNumber);	
		return levelNumber[1];
	}
	public static int [] findLeftMost(TreeNode root,int level,int [] levelNumber){
		if(root.left!=null){
			level++;
			findLeftMost(root.left, level,levelNumber);
			level--;
		}
		if(root.right!=null){
			level++;
			findLeftMost(root.right, level,levelNumber);
			level--;
		}
		if(root.left==null&&root.right==null){
			if(level>levelNumber[0]){
				levelNumber[1]=root.val;
				levelNumber[0]=level;
			}
		}
		return levelNumber;
	}
	public static void main(String[] args){
		 TreeNode root = new TreeNode(1);
		 TreeNode left = new TreeNode(2);
		 TreeNode right = new TreeNode(3);
		 TreeNode a = new TreeNode(4);
		 TreeNode b = new TreeNode(5);
		 TreeNode c = new TreeNode(7);
		 root.left=left;
		 root.right=right;
		 left.left=a;
		 right.left=b;
		 b.left=c;
		 findBottomLeftValue(root);
	}
}
