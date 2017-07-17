package leetcode.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 	測資真狠!!!!
 * 	1. 4個for暴力硬解  time limit, n^4
 * 	2. 4個for, 把相同的值給去掉 time limit,n^4
 * 	3. 3個for, 用一個先特殊DMap存好D再比較time limit,n^3
 * 	4. 可以先做AB和, 再做CD(D&C)和+存結果在Map , n^2(需再改進)
 * 
 * @author brian
 *
 */
public class fourSumTwo {
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		//每一次迭代的
		int count=0;
		int CDCount=0;
		int ABCount=0;
		Map<Integer,Integer> ABResult = new HashMap<Integer,Integer>();
		Map<Integer,Integer> CDResult = new HashMap<Integer,Integer>();
		for( int i = 0 ; i < A.length; i++){
			for(int j = 0 ; j < B.length ; j ++){
				ABCount= A[i]+B[j];
				if(ABResult.containsKey(ABCount)){
					count = ABResult.get(ABCount);
					ABResult.put(ABCount, ++count);
				}else{
					ABResult.put(ABCount, 1);
				}
			}
		}
		for( int k = 0 ; k < C.length ; k++){
			for(int z = 0 ; z < D.length ; z ++){
				CDCount= C[k]+D[z];
				if(CDResult.containsKey(CDCount)){
					count = CDResult.get(CDCount);
					CDResult.put(CDCount, ++count);
				}else{
					CDResult.put(CDCount, 1);
				}
			}
		}
		count =0 ;
		for(Integer abSum : ABResult.keySet() ){
			CDCount= 0-abSum;
			if(CDResult.containsKey(CDCount)){
				count = count + ABResult.get(abSum)*CDResult.get(CDCount);
			}
		}
		return count;
    }
	public static void main(String[] args){
		int [] A={-1,-1};
		int [] B={-1, 1};
		int [] C={-1,1};
		int [] D={1,-1};
		fourSumCount(A,B,C,D);
	}
}

//2
//int DCount = 0 ;
//int CCount=0;
//int BCount=0;
//int ACount=0;
//Map<Integer,Integer> checkARepeat = new HashMap<Integer,Integer>();
//Map<Integer,Integer> checkBRepeat = new HashMap<Integer,Integer>();
//Map<Integer,Integer> checkCRepeat = new HashMap<Integer,Integer>();
//for( int i = 0 ; i < A.length; i++){
//	if(checkARepeat.containsKey(A[i])){
//		ACount = ACount+checkARepeat.get(A[i]);
//		continue;
//	}
//	for(int j = 0 ; j < B.length ; j ++){
//		if(checkBRepeat.containsKey(B[j])){
//			BCount = BCount+checkBRepeat.get(B[j]);
//			continue;
//		}
//		for( int k = 0 ; k < C.length ; k++){
//			if(checkCRepeat.containsKey(C[k])){
//				CCount = CCount+checkCRepeat.get(C[k]);
//				continue;
//			}
//			for(int z = 0 ; z < D.length ; z ++){
//				if(A[i]+B[j]+C[k]+D[z]==0){
//					DCount ++;
//				}
//			}
//			CCount = CCount+DCount;
//			checkCRepeat.put(C[k], DCount);
//			DCount=0;
//		}
//		BCount = BCount+CCount;
//		checkBRepeat.put(B[j], CCount);
//		CCount=0;
//		checkCRepeat.clear();
//	}
//	ACount = ACount+BCount;
//	checkARepeat.put(A[i], BCount);
//	BCount=0;
//	checkBRepeat.clear();
//}
//return ACount;

//3
////每一次迭代的
//		int count =0;
//		int DCount = 0 ;
//		int CCount=0;
//		int BCount=0;
//		int ACount=0;
//		Map<Integer,Integer> checkARepeat = new HashMap<Integer,Integer>();
//		Map<Integer,Integer> checkBRepeat = new HashMap<Integer,Integer>();
//		Map<Integer,Integer> checkCRepeat = new HashMap<Integer,Integer>();
//		Map<Integer,Integer> DMap = new HashMap<Integer,Integer>();
//		for(int i = 0 ; i < D.length ; i++){
//			if(DMap.containsKey(D[i])){
//				count = DMap.get(D[i]);
//				DMap.put(D[i],++count);
//			}else{
//				DMap.put(D[i],1);
//			}
//		}
//		for( int i = 0 ; i < A.length; i++){
//			if(checkARepeat.containsKey(A[i])){
//				ACount = ACount+checkARepeat.get(A[i]);
//				continue;
//			}
//			for(int j = 0 ; j < B.length ; j ++){
//				if(checkBRepeat.containsKey(B[j])){
//					BCount = BCount+checkBRepeat.get(B[j]);
//					continue;
//				}
//				for( int k = 0 ; k < C.length ; k++){
//					if(checkCRepeat.containsKey(C[k])){
//						CCount = CCount+checkCRepeat.get(C[k]);
//						continue;
//					}
//					count = 0-(A[i]+B[j]+C[k]);
//					if(DMap.containsKey(count)){
//						DCount=DMap.get(count);
//					}
//					CCount = CCount+DCount;
//					checkCRepeat.put(C[k], DCount);
//					DCount=0;
//				}
//				BCount = BCount+CCount;
//				checkBRepeat.put(B[j], CCount);
//				CCount=0;
//				checkCRepeat.clear();
//			}
//			ACount = ACount+BCount;
//			checkARepeat.put(A[i], BCount);
//			BCount=0;
//			checkBRepeat.clear();
//		}
//		return ACount;


