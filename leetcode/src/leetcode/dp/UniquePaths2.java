package leetcode.dp;
/****
 * 首列,首行先檢查,遇到障礙,後面全改為障礙
 * 再將0->1,1->0 做unique path1即可
 * @author brian
 *
 */
public class UniquePaths2 {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid==null ||obstacleGrid[0][0]==1){
			return 0;
		}
		//列
		int m = obstacleGrid.length;
		//行
		int n = obstacleGrid[0].length;
		for(int i=1; i < n ; i++){
			if(obstacleGrid[0][i-1]==1){
				obstacleGrid[0][i]=1;
			}
		}
		for(int j=1; j < m ; j++){
			if(obstacleGrid[j-1][0]==1){
				obstacleGrid[j][0]=1;
			}
		}
		for(int i =0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				if(i==0){
					if(obstacleGrid[0][j]==0){
						obstacleGrid[0][j]=1;
					}else{
						obstacleGrid[0][j]=0;
					}
				}else if(j==0){
					if(obstacleGrid[i][0]==0){
						obstacleGrid[i][0]=1;
					}else{
						obstacleGrid[i][0]=0;
					}
				}else{
					if(obstacleGrid[i][j]==1){
						obstacleGrid[i][j]=0;
					}else{
						obstacleGrid[i][j]=obstacleGrid[i][j-1]+obstacleGrid[i-1][j];
					}
				}
			}
		}
		return obstacleGrid[m-1][n-1];
    }
	public static void main(String[] args){
		int[][] obstacleGrid ={{0,0},{1,1},{0,0}};
		//{{0,0,0},{0,1,0},{0,0,0}}
		uniquePathsWithObstacles(obstacleGrid);
	}
}
