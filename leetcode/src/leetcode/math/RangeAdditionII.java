package leetcode.math;
/**
 * 
 * 
 * 想法1->
 *  暴力法:
 *  建立一個m*n的陣列
 *  然後迭代ops, 在每一個m*n陣列的對應位置+1
 *  再去迭代m*n陣列, 找出最大值的個數------------------->方法無效(m=40000, n=40000 memory有問題),且時間空間複雜度都大
 * 
 * 
 * 想法2->
 * 
 * 觀察ops, 發現只需要取ops[0->ops.length][0]的min 和 ops[0->ops.length][1] 的min 
 * 在相乘即為答案
 * 
 * ex: 
 *    m=40000, n=40000
 *    (16,2)  (15,3)  (2,7)
 *    
 *    1. (16,2) -> (0-15,0),(0-15,1)這些值需+1-->先視這些數為最大值
 *    2. (15,3) -> (0-14,0),(0-14,1),(0-14,2)-->最大值縮小了, 變成(0-14,0),(0-14,1)
 *    3. (2,7) -> (0-1,0),(0-1,1),(0-1,2)...(0-1,6)-->最大值又縮小了,變成(0-1,0),(0-1,1)
 *    ....以此類推
 *    
 *  
 *    
 * 
 * 
 * @author brian
 *
 */
public class RangeAdditionII {
	  public static int maxCount(int m, int n, int[][] ops) {
		int zeroMin=0 ;
		int oneMin =0;
		if(ops==null||ops.length ==0){
			return m*n ;
		}
		zeroMin=ops[0][0];
		oneMin=ops[0][1];
		for(int i = 1 ; i  < ops.length ; i++){
			if(ops[i][0]==0||ops[i][1]==0){
				return 0;
			}
			zeroMin=Math.min(ops[i][0], zeroMin);
			oneMin = Math.min(ops[i][1], oneMin);
		}
		  return zeroMin*oneMin;
	  }
	  public static void main(String[] args){
		  //int [] [] ops = {{2,1},{3,3}};
		  int [] [] ops = {{}};
	    	maxCount(40000,40000,ops);
	    }
}
////int [][] mnArray;
//		int min=0 ;
//		int count=0;
//		if(ops==null||ops.length ==0){
//			return m*n ;
//		}
//		//mnArray = new int [m][n];
//		for(int i = 0 ; i  < ops.length ; i++){
//			if(ops[i][0]==0||ops[i][1]==0){
//				return 0;
//			}
//			count = ops[i][0]*ops[i][1];
//			if(count<min){
//				min=count;
//			}
//			//for(int j =0 ; j < ops[i][0] ; j++){
//				//for(int k =0 ; k<ops[i][1]; k++){
//					//mnArray[j][k] = mnArray[j][k]+1;
//					
//				//}
//			//}
//		}
////		for(int i = 0 ; i < mnArray.length ; i++){
////			for(int j = 0 ; j < mnArray[i].length ; j++){
////				if(mnArray[i][j]>max){
////					max=mnArray[i][j];
////					count=1;
////					continue;
////				}
////				if(mnArray[i][j]==max){
////					count++;
////				}
////			}
////		}
//		  return min;