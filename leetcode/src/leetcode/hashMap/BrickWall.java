package leetcode.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *  因為length都一樣, 只要迭代每一層array, 開始累加, 在把累加的數字塞入map中進行統計, 找出最大值 , 在用array長度-最大值即答案
 *  ex:
 *                         [[1,2,2,1],
 							[3,1,2],
 							[1,3,2],
 							[2,4],
 							[3,1,2],
 							[1,3,1,1]]
 *  
 * 						1->1
 * 						3->1	
 *							5->1
 *
 *  						1->1
 *  						3->2
 *  						4->1
 *  						5->1
 * 						以此類推 
 *  
 * @author brian
 *
 */
public class BrickWall {
	public int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> resultMap = new HashMap<Integer,Integer>();
		int sum=0;
		int count;
		int max=0;
		for(int i =0 ; i < wall.size() ; i ++){
			for(int j = 0 ; j < wall.get(i).size()-1 ; j++){
				sum=sum+wall.get(i).get(j);
				if(resultMap.containsKey(sum)){
					count=resultMap.get(sum);
					resultMap.put(sum, ++count);
				}else{
					resultMap.put(sum, 1);
				}
			}
			sum=0;
		}
		for(Integer length: resultMap.keySet()){
			max=Math.max(max, resultMap.get(length));
		}
		return wall.size()-max;
    }
	public static void main(String[] args){
		//List<List<Integer>> wall = new ArrayList<List<Integer>>();
		
	}
}
