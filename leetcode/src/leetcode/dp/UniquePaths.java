package leetcode.dp;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
    	int[][] resultArr = new int[m][n];
		for(int i =0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				if(i==0){
					resultArr[i][j]=1;
				}else if(j==0){
					resultArr[i][j]=1;
				}else{
					resultArr[i][j]=resultArr[i][j-1]+resultArr[i-1][j];
				}
			}
		}
    	return resultArr[m-1][n-1];
    }
    public static void main(String[] args){
		uniquePaths(3,7);
	}
}
