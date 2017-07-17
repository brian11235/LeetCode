package leetcode.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 
 * 注意: List 不可以寫=, 要寫addAll 判斷
 * 
 * 思路1: 用兩次迭代, 判斷每一行是否有2個1, 如果有的話就把count--(count=array的長度), return 的時候判斷count 是否= array長度, 決定回傳的數字--->沒辦法判斷2組以上的friend group
 * ex: {1,1,0,0}{1,1,0,0 }{0,0,1,1}{0,0,1,1}
 * 
 * 思路2: 相當複雜, 須找出更好的辦法
 * 直接ex:    
 *  (0,9)-->0
 *  (1,3,13)-->1
 *  (2)-->2
 *  (1,3,7,11)-->3
 *  (4,12)-->4
 *  (5)-->5
 *  (6)-->6
 *  (3,7,8)-->7
 *  (7,8)-->8
 *  (0,9)-->9
 *  (10)-->10
 *  (3,11)-->11
 *  (4,12)-->12
 *  (1,13)-->13
 *  (14)-->14
 * 上述是一個整理過的輸入, (0,9)--->0代表 0這行有0 ,9 = 1 其餘=0 
 * 只要size=1, 就是自己一個friend group
 * 其餘的要聯集並分組就可以知道總共有幾個group(用set長度來判斷聯集的結果)
 * 
 * PS. 小心下面這組ex(判斷到1的時候, array裡面會有兩組group(0,3)(1,2),但是到3的時候,應該會聯集變成只有一組)
 * ex2: 
 * (0,3)-->0
 * (1,2)--->1
 * (1,2,3)-->2
 * (0,2,3)--->3
 * 
 * @author brian
 *
 */
public class FriendCircles {
    public static int findCircleNum(int[][] M) {
		List<Set<Integer>> groupSetList = new ArrayList<Set<Integer>>();
    	Set<Integer> rowSet = new HashSet<Integer>();
    	Set<Integer> tempSet = new HashSet<Integer>();  
    	int originalLen;
    	for(int i = 0 ; i < M.length ; i++){
    	    for(int j = 0 ; j < M.length ; j++){
    	    	if(M[i][j]==1){
    	    		rowSet.add(j);
    	    	}
    	    }
    	    if(groupSetList.size()==0||rowSet.size()==1){
    	    	groupSetList.add(rowSet);
    	    }else{
    	    	for(int k= 0 ; k < groupSetList.size() ; k++){
        	    	tempSet.addAll(groupSetList.get(k));
        	    	originalLen = tempSet.size();
        	    	tempSet.addAll(rowSet);
        	    	if(tempSet.size()!=originalLen+rowSet.size()){
        	    		groupSetList.remove(k);
        	    		//groupSetList.add(tempSet);
        	    		//break;
        	    		rowSet.clear();
        	    		rowSet.addAll(tempSet);
        	    		k--;
        	    	}
        	    	if(k==groupSetList.size() -1){
        	    		groupSetList.add(rowSet);
        	    		break;
        	    	}
        	    	tempSet.clear();
        	    }
    	    }
    	    tempSet= new HashSet<Integer>(); 
    	    rowSet = new HashSet<Integer>(); 
    	}
    	return groupSetList.size();
    }
    public static void main(String[] args){
    	int [][]M={{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
    			//{{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
    	findCircleNum(M);
    }
}
//int count = M.length;
//for(int i = 0 ; i < M.length ; i++){
//    for(int j = 0 ; j < M.length ; j++){
//        if(i!=j&&M[i][j]==1){
//            count--;
//            break;
//        }
//    }
//} 
//return count==M.length?count:count+1;

//{{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
//[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]