package leetcode.dp;

import java.util.HashMap;
import java.util.Map;
/**
 * f(0)=0
 * f(1)=1
 * f(2)=1
 * f(3) = f(2)+f(3-2)=2
 * 以此類推
 * @author brian
 *
 */
public class CountingBits {
	public static int[] countBits(int num) {
		//Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		int [] resultArr = new int[num+1]; 
		int pow=1;
		resultArr[0]=0;
		for(int i =1 ; i <= num ; i++){
			if(pow==i){
				resultArr[i]=1;
				pow *=2;
			}else{
				resultArr[i]=1+resultArr[i-pow/2];
			}
		}
		return resultArr;
        
    }
	 public static void main(String[] args){
		 countBits(9);
	 }
}
//if(i==0){
//	map.put(0, 0);
//}else if(i==1){
//	map.put(1, 1);
//	resultArr[i]=1;
//}else{
//	if(i==Math.pow(2, pow)){
//		map.put(i, 1);
//		resultArr[i]=1;
//		pow++;
//	}else{
//		map.put(i, map.get((int)Math.pow(2, pow-1))+map.get(i-((int)Math.pow(2, pow-1))));
//		resultArr[i]=map.get(i);
//	}
//}