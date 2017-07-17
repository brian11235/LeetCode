/**
 * 
 */
package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author brian
 *
 */
public class romanToInteger {
	public static int romanToInt(String s) {
		Map<String,Integer> indexMap = new HashMap<String,Integer>();
		char[] charArr=s.toCharArray();
		int[] numArr = new int[s.length()];
		int i = 0,index=0;
		int finalInt=0;
		indexMap.put("I", 1);
		indexMap.put("V", 5);
		indexMap.put("X", 10);
		indexMap.put("L", 50);
		indexMap.put("C", 100);
		indexMap.put("D", 500);
		indexMap.put("M", 1000);
		if(s.length()==1){
			return indexMap.get(s);
		}else{
			finalInt=indexMap.get(String.valueOf(charArr[0]));
			for(Character a:charArr){
				numArr[i]=indexMap.get(a.toString());
				i++;
				if(i>1){
					if(numArr[i-1]-numArr[i-2]>0){
						//index: 後面還有比前面更大的數字 IV
						if(index==1){
							finalInt = finalInt+numArr[i-1]-numArr[i-2]*2;
						}else{
							finalInt = numArr[i-1]-numArr[i-2];
						}						
					}else if(numArr[i-1]-numArr[i-2]==0){
						finalInt = finalInt+numArr[i-1];
					}else{
						finalInt = finalInt+numArr[i-1];
						index=1;
					}
				}
			}
		}
		return finalInt;
    }
	public static void main(String[] args) {
		String s = "LXXXIV";
		int finalInt;
		finalInt=romanToInt(s);
		System.out.println(finalInt);
	}
	
}
