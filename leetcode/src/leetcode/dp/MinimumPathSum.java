package leetcode.dp;
/**
 * DP : 比較當下這位的前一位和上一位的和
 * @author brian
 *
 */
public class MinimumPathSum {
	  public static int minPathSum(int[][] grid) {
		int row = grid[0].length;
		int column = grid.length;
		
		for(int i = 0 ; i < column ; i ++){
			for(int j =0 ; j < row ; j++){
				if(i==0 && j==0){
					continue;
				}else if(i==0){
					grid[0][j]=grid[0][j]+grid[0][j-1];
				}else if(j==0){
					grid[i][0]=grid[i][0]+grid[i-1][0];
				}else{
					grid[i][j]=grid[i][j]+Math.min(grid[i-1][j], grid[i][j-1]);
				}
			}
		}
		return grid[column-1][row-1];
	   }
	  public static void main(String[] args){
			int[][] nums = {{1,2,1},{1,1,1}};
			minPathSum(nums);
		}
	  
}
