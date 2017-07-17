package leetcode.dp;

import java.util.ArrayList;
import java.util.List;
/***
 * 修改triangle的值,再找最後一行的最小值
 * @author brian
 *
 */
public class Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
		int min = 0;
		for(int i = 0 ; i < triangle.size() ; i++){
			for(int j = 0 ; j < triangle.get(i).size() ; j++ ){
				if(i==0){
					min=triangle.get(i).get(j);
				}else{
					if(j==0){
						triangle.get(i).set(j, triangle.get(i-1).get(0)+triangle.get(i).get(0));
					}else if(j==triangle.get(i).size()-1){
						triangle.get(i).set(j, triangle.get(i-1).get(triangle.get(i-1).size()-1)+triangle.get(i).get(triangle.get(i).size()-1));
					}else{
						triangle.get(i).set(j, Math.min(triangle.get(i-1).get(j-1)+triangle.get(i).get(j), triangle.get(i-1).get(j)+triangle.get(i).get(j)));
					}
				}
				if(i==triangle.size()-1){
					if(j==0){
						min=triangle.get(i).get(0);
					}else{
						min = Math.min(min, triangle.get(i).get(j));
					}
				}
			}
		}
		return min;
    }
	public static void main(String[] args){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> li = new ArrayList<Integer>();
		List<Integer> li2 = new ArrayList<Integer>();
		List<Integer> li3 = new ArrayList<Integer>();
		li.add(-1);
		li2.add(2);
		li2.add(3);
		li3.add(1);
		li3.add(-1);
		li3.add(-3);
		triangle.add(li);
		triangle.add(li2);
		triangle.add(li3);
		minimumTotal(triangle);
	}
}
