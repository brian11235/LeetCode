package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * 思路1: 幾乎同BinaryTreeLevelOrderTraversal, 把queue改為stack存取
 * ex:       3--->left先
 * 		/      \
 *       9        20 ----> right先
 *		/ \         /\ 
 *   2   8     15 7  ---->left先                       ----->這樣交錯去存取stack(錯誤)!!!!!
 *                                                                      ------> 當20從stack pop出去之後, 下一個pop會變為15而不是9(因為後進先出)
 *  思路2: 改為兩個stack, 一個存input, 一個存output, AC!
 *   
 * @author brian
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Integer> levelNumber= new ArrayList<Integer>();
        Stack<TreeNode> outStack = new Stack<TreeNode>();
        Stack<TreeNode> inStack = new Stack<TreeNode>();
        int level=1;
        int levelCount =1;
        List<List<Integer>> zigNumber = new ArrayList<List<Integer>>();
        TreeNode temp = root;
        outStack.push(temp);
        while(root!=null&&!outStack.isEmpty()){
            temp = outStack.pop();
            levelNumber.add(temp.val);
            levelCount--;    
            if(level%2==0){
                if(temp.right!=null){
                	inStack.push(temp.right);
                }
                if(temp.left!=null){
                	inStack.push(temp.left);
                }
            }else{
            	if(temp.left!=null){
                	inStack.push(temp.left);
                }
            	 if(temp.right!=null){
                 	inStack.push(temp.right);
                 }
            }
            if(levelCount==0){
            	level++;
            	outStack=inStack;
            	inStack=new Stack<TreeNode>();
            	levelCount=outStack.size();
            	zigNumber.add(levelNumber);
            	levelNumber = new ArrayList<Integer>();
            }
        }
		return zigNumber;
    }
	public static void main(String[] args){
		 TreeNode root = new TreeNode(3);
		 TreeNode left = new TreeNode(9);
		 TreeNode right = new TreeNode(20);
		 TreeNode a = new TreeNode(2);
		 TreeNode b = new TreeNode(8);
		 TreeNode c = new TreeNode(15);
		 TreeNode d = new TreeNode(7);
		 TreeNode e = new TreeNode(5);
		 TreeNode f = new TreeNode(6);
		 root.left=left;
		 root.right=right;
		 left.left=a;
		 left.right=b;
		 right.left=c;
		 right.right=d;
		 //d.left=e;
		 //right.left=f;
		 zigzagLevelOrder(root);
	}
}
