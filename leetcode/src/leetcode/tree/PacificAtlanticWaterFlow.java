package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
	public static List<int[]> pacificAtlantic(int[][] matrix) {
		List<int []> flowList = new ArrayList<int []>();
		boolean status;
		int [] position = new int[2];
		int original = -1;
		for(int i = 0 ; i < matrix.length ; i++){
			for(int j = 0 ; j < matrix[i].length ; j++){
				status=bFSPacificAtlantic(i, j,matrix,original);
				if(status==true){
					position[0]=i;
					position[1]=j;
					flowList.add(position);
					position = new int[2];
				}
			}
		}
		return flowList;   
    }
	public static boolean  bFSPacificAtlantic(int i, int j, int [][] matrix,int original){
		boolean up;
		boolean down;
		boolean left;
		boolean right;
		if(i==-1||i==matrix.length||j==-1||j==matrix.length){
			return true;
		}
		if(original!=-1&&matrix[i][j]>original){
			return false;
		}
		//上
		up=bFSPacificAtlantic(i-1, j,matrix,matrix[i][j]);
		//下
		down=bFSPacificAtlantic(i+1, j,matrix,matrix[i][j]);
		//左
		left=bFSPacificAtlantic(i, j-1,matrix,matrix[i][j]);
		//右
		right=bFSPacificAtlantic(i, j+1,matrix,matrix[i][j]);
		
		//判斷上下左右的狀態
		if((up==true||left==true)&&(down==true||right==true)){
			return true;
		}
		return false;
	}
	public static void main(String[] args){
		int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		pacificAtlantic(matrix);
	}
}
//if(i==-1||i==matrix.length){
//	status[0]=true;
//	return status;
//}
//if(j==-1||j==matrix[i].length){
//	status[1]=true;
//	return status;
//}
//List<int []> flowList = new ArrayList<int []>();
//List<int []>pathList = new ArrayList<int []>();
//boolean status;
//int [] position = new int[2];
//int original = -1;
//for(int i = 0 ; i < matrix.length ; i++){
//	for(int j = 0 ; j < matrix[i].length ; j++){
//		status=bFSPacificAtlantic(i, j,matrix,original,pathList);
//		if(status==true){
//			position[0]=i;
//			position[1]=j;
//			flowList.add(position);
//			position = new int[2];
//		}
//		pathList = new ArrayList<int []>();
//	}
//}
//return flowList;   
//}
//public static boolean  bFSPacificAtlantic(int i, int j, int [][] matrix,int original,List<int []>pathList){
//boolean up;
//boolean down;
//boolean left;
//boolean right;
//int [] path = new int[2];
//if(i==-1||i==matrix.length||j==-1||j==matrix.length){
//	return true;
//}
//if(original!=-1&&matrix[i][j]>original){
//	return false;
//}
////紀錄每一筆路徑,避免走回頭路
//for(int [] route: pathList){
//	if(route!=null&&route[0]==i&&route[1]==j){
//		return true;
//	}
//}
//path[0]=i;
//path[1]=j;
//pathList.add(path);
////上
//up=bFSPacificAtlantic(i-1, j,matrix,matrix[i][j],pathList);
////下
//down=bFSPacificAtlantic(i+1, j,matrix,matrix[i][j],pathList);
////左
//left=bFSPacificAtlantic(i, j-1,matrix,matrix[i][j],pathList);
////右
//right=bFSPacificAtlantic(i, j+1,matrix,matrix[i][j],pathList);
//
////判斷上下左右的狀態
//if((up==true||left==true)&&(down==true||right==true)){
//	return true;
//}
//return false;