package leetcode.binarySearch;
/**
 * 
 * 小心[[]],[[1]]這種測資
 * 
 * 思路: 先取出martrix 的第一列, 找出target在哪個區間, 然後再BS這個區間找答案~
 * 
 * 
 * @author brian
 *
 */
public class Searcha2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = 0;
		int left=0;
		int right;
		int mid;
		if(matrix==null||matrix.length==0||matrix[0].length==0){
			return false;
		}
		for(int i = 0 ; i < matrix.length ; i++){
			if(target>=matrix[i][0]&&target<=matrix[i][matrix[i].length-1]){
				row=i;
			}
		}
		right = matrix[row].length-1;
		while(left<=right){
			mid = (left+right)/2;
			if(matrix[row][mid]>target){
				right = mid-1;
			}else if(matrix[row][mid]<target){
				left = mid+1;
			}else{
				return true;
			}
		}
		return false;
    }
	public static void main(String[] args){
		int[][] matrix={{}};
		searchMatrix(matrix,1);
	}
}

//if(matrix[i][0]>target){
//	row = i-1;
//	break;
//}else if(matrix[i][0] ==target){
//	return true;
//}
