package leetcode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.dp.UniqueBinarySearchTrees2.TreeNode;
/**
 * 如果数组为空，毫无疑问，只有一种BST，即空树，
Count[0] =1

如果数组仅有一个元素{1}，只有一种BST，单个节点
Count[1] = 1

如果数组有两个元素{1,2}， 那么有如下两种可能
1                       2
  \                    /
    2                1
Count[2] = Count[0] * Count[1]   (1为根的情况)
                  + Count[1] * Count[0]  (2为根的情况。

再看一遍三个元素的数组，可以发现BST的取值方式如下：
Count[3] = Count[0]*Count[2]  (1为根的情况)
               + Count[1]*Count[1]  (2为根的情况)
               + Count[2]*Count[0]  (3为根的情况)
 * @author brian
 *
 */
public class UniqueBinarySearchTrees {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { 
	    	  val = x; 
	      }
	}
	 public static int numTrees(int n) {
		 int result = 0;
		 Map<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
		 indexMap.put(0, 1);
		 indexMap.put(1, 1);
		 if(n==0||n==1){
			 return 1;
		 }
		 for(int i = 2 ; i <=n ; i ++){
			 for(int j=1; j <=i ; j ++){
				 result=result+indexMap.get(j-1)*indexMap.get(i-j);
			 }
			 indexMap.put(i,result);
			 result=0;
		 }
		 
		 
		return indexMap.get(n);
	 }
	public static void main(String[] args){
		numTrees(3);
	}
}
