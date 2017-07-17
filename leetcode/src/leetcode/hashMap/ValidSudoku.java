package leetcode.hashMap;

import java.util.ArrayList;
import java.util.List;
/**
 * 檢查三步驟
 * 1. row 
 * 2. column 
 * 3. 9宮格
 * @author brian
 *
 */
public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		int count = 0;
		List<Character> rowList = new ArrayList<Character>();
		if(board == null || board.length==0){
			return false;
		}
		for(int i =0 ; i < board.length ; i++ ){
			for( int j =0 ; j < board[0].length ; j++){
				if(board[i][j]=='.'){
					continue;
				}
				if(!rowList.contains(board[i][j])){
					rowList.add(board[i][j]);
				}else{
					return false;
				}
			}
			rowList.clear();
		}
		
		for(int i =0 ; i < board[0].length ; i++ ){
			for( int j =0 ; j < board.length ; j++){
				if(board[j][i]=='.'){
					continue;
				}
				if(!rowList.contains(board[j][i])){
					rowList.add(board[j][i]);
				}else{
					return false;
				}
			}
			rowList.clear();
		}
		
		for(int i =0 ; i<9&&i < board[i].length ; i+=3 ){
			for( int j =0; j < board.length ; j++){
				for(int k = i ; k < i+3 ; k++){
					if(board[j][k]=='.'){
						count++;
						continue;
					}
					if(!rowList.contains(board[j][k])){
						rowList.add(board[j][k]);
					}else{
						return false;
					}
					count++;
				}
				if(count==9){
					rowList.clear();
					count=0;
				}
			}
		}
		return true;
    }
	public static void main(String[] args){
		char[][] board = new char[9][9];
		String[] strArr = {"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
		for(int i = 0 ; i < strArr.length ; i++){
			for( int j= 0 ; j < strArr[i].length() ; j ++){
				char a = strArr[i].charAt(j);
				board[i][j]=a;
			}
		}
		isValidSudoku(board);
	}
}
