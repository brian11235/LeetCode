package leetcode.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 重點在於 需找出int[]A中可能是等差數列, 然後再找出int[]A數列中有幾組等差數列和各自數列的組合
 * 
 * 1.用雙指針(i做為旗標 , j去累加數列)
 * 2. 1,2,3->1
 * 	 1,2,3,4->1+2
 * 	 1,2,3,4,5->1+2+3........以此類推即可得答案
 * 
 * @author brian
 *
 */
public class ArithmeticSlices {
	 public static int numberOfArithmeticSlices(int[] A) {
		 int preDif = 0;
		 int dif;
		 int i=0;
		 int count=0;
		 if(A==null||A.length<3){
			 return 0;
		 }
		for(int j=1 ; j < A.length ; j++){
			if(j-i<2){
				preDif = A[j]-A[i];
			}else{
				dif=A[j]-A[j-1];
				if(dif!=preDif){
					i=j-1;
				}else{
					count = count +(j-i-1);
				}
				preDif=dif;
			}
		}
		return count;
	        
	 }
	 public static void main(String[] args){
		 int[] A={5,3,4,5,6,7,9,10};
		 numberOfArithmeticSlices(A);
	 }
}
