package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.tree.BinaryTreeInorderTraversal.TreeNode;
/**
 * 
 * 注意:
 * [5,3,6,2,4,null,null,1]
		node with value 1
		node with value 4(跳行例子)
 * 
 * 
 * @author brian
 *
 */
public class LowestCommonAncestorofaBinarySearchTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> childList = new ArrayList<TreeNode>();
		List<TreeNode> res = new ArrayList<TreeNode>();
		res=dfsCommonAncestor(root, p,  q, childList,res);
		return res.get(0);
    }
	public static List<TreeNode> dfsCommonAncestor(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> childList,List<TreeNode> res){
		if(root.left!=null){
			dfsCommonAncestor(root.left, p,  q, childList,res);
		}
		if(root.right!=null){
			dfsCommonAncestor(root.right, p,  q, childList,res);
		}
		//if(root.left!=null||root.right!=null){
			if(childList.contains(p)&&childList.contains(q)){
				res.add(root);
			}else if(root==p && childList.contains(q)){
				res.add(p);
			}else if(root==q && childList.contains(p)){
				res.add(q);
			}else{
				childList.add(root.left);
				childList.add(root.right);
				return childList;
			}
		//}
		return res;
	}
	public static void main(String[] args){
		 TreeNode root = new TreeNode(2);
		 TreeNode left = new TreeNode(1);
		 TreeNode right = new TreeNode(3);
		 root.left=left;
		 root.right=right;
		 lowestCommonAncestor(root,left,right);
	}
}
//if((root.left==p&&root.right==q)||(root.left==q&&root.right==p)){
//	res=root;
//}else if(root==p&&(left==q||right==q)){
//	res=p;
//}else if(root==q&&(left==p||right==p)){
//	res=q;
//}else{
//	res=root;


//if(!res.isEmpty()){
//	return res;
//}
//if(root==null){
//	return childList;
//}
//childList=dfsCommonAncestor(root.left, p,  q, childList,res);
//childList=dfsCommonAncestor(root.right, p,  q, childList,res);
//if(childList.contains(p)&&childList.contains(q)){
//	res.add(root);
//}else if(root==p && childList.contains(q)){
//	res.add(p);
//}else if(root==q && childList.contains(p)){
//	res.add(q);
//}else{
//	childList.add(root);
//	return childList;
//}