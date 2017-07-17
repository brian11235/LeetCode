package leetcode.binarySearch;
/**
 * 思路:判斷target有沒有再每一行中間, 有就做BS檢查, 沒有就break~
 * 
 * @author brian
 *
 */
public class Searcha2DMatrixII {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int left;
		int right ;
		int mid;
		if(matrix==null||matrix.length==0||matrix[0].length==0){
			return false;
		}
		for(int i = 0 ; i < matrix.length ; i++){
			if(target < matrix[i][0]&&target>matrix[i][matrix[i].length-1]){
				break;
			}
			left=0;
			right = matrix[i].length-1;
			while(left<=right){
				mid=(left+right)/2;
				if(target == matrix[i][mid]){
					return true;
				}else if(target > matrix[i][mid]){
					left = mid+1;
				}else{
					right = mid-1;
				}
			}
		}
		return false; 
    }
	public static void main(String[] args){
		int[][] matrix={{1,4,7,11,15},{2,5,8,12,19}};
		searchMatrix(matrix,5);
	}
}
