package leetcode.dp;

import java.util.HashMap;
import java.util.Map;
/**
 *  用map紀錄重覆的數字
 * @author brian
 *
 */
public class ClimbingStairs {
	public static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	public static int climbStairs(int n) {
		int total;
		if(map.containsKey(n)){
			return map.get(n);
		}
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}
		total=climbStairs(n-1)+climbStairs(n-2);
		map.put(n, total);
		return total;
    }
	public static void main(String[] args){
		int a =climbStairs(5);
		System.out.println(a);
	}
}
