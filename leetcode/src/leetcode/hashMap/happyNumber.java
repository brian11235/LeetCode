package leetcode.hashMap;

import java.util.ArrayList;
import java.util.List;

public class happyNumber {
	public static boolean isHappy(int n) {
			List li = new ArrayList();
			int result;
			while(li!=null){
				result=countNumber(n);
				if(li.contains(result)){
					return false;
				}else if(result == 1){
					return true;
				}else{
					li.add(result);
					n=result;
				}
			}	
		return false;  
    }
	public static int countNumber(int n){
		char[] number=String.valueOf(n).toCharArray();
		int count = 0;
		for(int i=0 ; i < number.length;i++){
			count = count+Integer.parseInt((String.valueOf(number[i])))*Integer.parseInt((String.valueOf(number[i])));
		}
		return count;
	}
	public static void main(String[] args){
		int n=19;
		isHappy(n);
	}
}
