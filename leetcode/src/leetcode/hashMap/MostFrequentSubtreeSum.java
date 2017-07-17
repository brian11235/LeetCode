package leetcode.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * 暴力法
 * 
 * 先對tree做DFS, 然後用map去紀錄SubtreeSum, 再把map做處理找出最大個數即可
 * 
 * @author brian
 *
 */
public class MostFrequentSubtreeSum {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	public static int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer,Integer> sumMap = new HashMap<Integer, Integer>();
		Map< Integer , List> resultMap = new HashMap< Integer , List>();
		List li;
		int count=0;
		int max=0;
		int [] resultArr =null ;
		if(root==null){
			return new int[0];
		}
		sumMap=combineMap(root,sumMap);
		if(sumMap.containsKey(root.val)){
			count = sumMap.get(root.val);
			sumMap.put(root.val, ++count);
		}else{
			sumMap.put(root.val, 1);
		}
		for(Integer sum : sumMap.keySet()){
			if(resultMap.containsKey(sumMap.get(sum))){
				resultMap.get(sumMap.get(sum)).add(sum);
			}else{
				li = new  ArrayList();
				li.add(sum);
				resultMap.put(sumMap.get(sum), li);
			}
		}
		for(Integer result : resultMap.keySet() ){
			max=Math.max(max, result);
		}
		resultArr = new int[resultMap.get(max).size()];
		for(int i = 0 ; i < resultMap.get(max).size() ; i++){
			resultArr[i] = (int) resultMap.get(max).get(i);
		}
		return resultArr;
    }
	public static Map combineMap(TreeNode root, Map<Integer,Integer> sumMap){
		int count=0;
		if(root.left!=null){
			combineMap(root.left, sumMap);
		}
		if(root.right!=null){
			combineMap(root.right, sumMap);
		}
		if(root.left!=null||root.right!=null){
			if(root.left!=null){
				if(root.left!=null&&sumMap.containsKey(root.left.val)){
					count = sumMap.get(root.left.val);
					sumMap.put(root.left.val, ++count);
				}else{
					sumMap.put(root.left.val, 1);
				}
				root.val =root.val+ root.left.val;
			}
			if(root.right!=null){
				if(root.right!=null&&sumMap.containsKey(root.right.val)){
					count = sumMap.get(root.right.val);
					sumMap.put(root.right.val, ++count);
				}else{
					sumMap.put(root.right.val, 1);
				}
				root.val =root.val+root.right.val;
			}
		}
		return sumMap;
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		root.left=new TreeNode(2);
		root.right=new TreeNode(-3);
		root.left.left=new TreeNode(1);
		//root.left.right=new TreeNode(2);
		root.right.left=new TreeNode(4);
		root.right.right=new TreeNode(5);
		findFrequentTreeSum(root);
	}
}
