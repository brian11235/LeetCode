package leetcode.array;
/**
 * 先算舊跟新矩陣大小是否一樣
 * 若是,用二維陣列放矩陣
 *
 * @author brian
 *
 */
public class ReshapetheMatrix {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
    	int originalRow = nums.length;
    	int originalColumn = nums[0].length;
    	int [][] newNums= new int[r][c];
    	if(originalRow*originalColumn!=r*c){
    		return nums;
    	}
    	r=0;
    	c=0;
    	for(int i = 0; i <nums.length ; i++){
    		for( int j =0 ; j < nums[i].length ; j++){
    			newNums[r][c]=nums[i][j];
    			c++;
    			if(c==newNums[0].length){
    				r++;
    				c=0;
    			}
    		}
    	}
		return newNums;
    }
    public static void main(String[] args){
    	//int [][] nums = {{1,2,4,6},{3,4,7,6},{3,2,5,4}};
    	int [][] nums = {{1,2},{3,4}};
    	matrixReshape(nums,4,1);
    }
}
