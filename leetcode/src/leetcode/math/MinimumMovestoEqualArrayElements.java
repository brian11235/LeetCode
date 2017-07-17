package leetcode.math;
/**
 *  思路1: 找出nums中所有的數(除了max), 將他們+1, 然後不段迭代直到所有值相等(時間太久太慢)
 *  思路2: 反向思考, 將最大的數-1(=思路1的第一句),然後不斷迭代減到最小值
 *  因為每個數都會減到最小, 所以題目可以改為先找出最小值, 然後答案即為每個數跟最小值的差總和
 * @author brian
 *
 */
public class MinimumMovestoEqualArrayElements {
	public int minMoves(int[] nums) {
		 int min=nums[0];
	        int totalMove=0;
	        for(int i = 1 ; i < nums.length ; i++){
	            min=Math.min(min,nums[i]);
	        }
	        for(int i = 0 ; i < nums.length ; i++){
	            totalMove = totalMove + nums[i]-min;
	        }
	        return totalMove;
    }
	public static void main(String[] args){
		//minMoves
	}
}
