package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 注意:  空的grid判斷
 * 思路:用DFS搜尋land的上下左右----> 建一個visited的二維陣列來紀錄'1'是否已經遞迴過
 * 
 * 
 * @author brian
 *
 */
public class NumberofIslands {
	public static int numIslands(char[][] grid) {
		int islandCount=0;
		if(grid==null||grid.length==0){
			return islandCount;
		}
		boolean [][] visited  = new boolean[grid.length][grid[0].length]; 	
		for(int i = 0 ; i<grid.length ; i++){
			for(int j =0; j < grid[i].length ; j++){
				if(grid[i][j]=='1'&&visited[i][j]!=true){
					visited=findLand(i,j,grid,visited);
					islandCount++;
				}
			}
		}
		return islandCount;
    }
	public static boolean [][]  findLand(int i , int j , char[][] grid,boolean [][] visited){
		if(i==-1||i==grid.length||j==-1||j==grid[0].length||grid[i][j]=='0'||visited[i][j]==true){
			return visited;
		}
		if(grid[i][j]=='1'){
			visited[i][j]=true;
		}
		//上
		visited=findLand( i-1, j , grid,visited);
		//下
		visited=findLand( i+1, j , grid,visited);
		//左
		visited=findLand( i, j-1 , grid,visited);
		//右
		visited=findLand( i, j+1 , grid,visited);
		return visited;
	}
	public static void main(String[] args){
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		numIslands(grid);
	}
}
