package leetcode.hashMap;

import java.util.HashMap;
import java.util.Map;
/*
 * 要比較兩個字串裡面的字元是否相同，首先可以判斷長度是否相等，不相等就可以直接判定為false， 接下來將重新排序後的字串比較是否相等
 * */
public class validAnagram {
	public static boolean isAnagram(String s, String t) {
		Map<String,Integer> sMap= new HashMap<String,Integer>();
		String [] sArr=s.split("");
		String [] tArr=t.split("");
		int value = 1;
		for(int i =0 ; i < sArr.length ; i++){
			if(sMap.containsKey(sArr[i])){
				value=sMap.get(sArr[i]);
				sMap.put(sArr[i], ++value);
			}else{
				sMap.put(sArr[i], value);
			}
			value = 1;
		}
		for(int i =0 ; i < tArr.length ; i++){
			if(sMap.containsKey(tArr[i])){
				value=sMap.get(tArr[i]);
				sMap.put(tArr[i], --value);
			}else{
				sMap.put(tArr[i], value);
				value=1;
			}
			if(value==0){
				sMap.remove(tArr[i]);
			}
		}
		if(!(sMap.isEmpty())){
			return false;
		}
		return true; 
    }
	
	public static void main(String[] args){
		isAnagram("a","ab");
	}
}
