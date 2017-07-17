package leetcode.hashMap;

import java.util.HashMap;
import java.util.Map;

public class findTheDifference {
	public static char findTheDifference(String s, String t) {
		Map<Character,Integer> sMap = new HashMap<Character,Integer>();
		char [] sArr = s.toCharArray();
		char [] tArr = t.toCharArray();
		int value;
		char result = 0;
		for(int i =0 ; i<sArr.length ; i++){
			if(sMap.containsKey(sArr[i])){
				value = sMap.get(sArr[i]);
				sMap.put(sArr[i], ++value);
			}else{
				value=1;
				sMap.put(sArr[i], value);
			}
		}
		for(int i=0; i<tArr.length;i++){
			if(sMap.containsKey(tArr[i])){
				value = sMap.get(tArr[i]);
				sMap.put(tArr[i], --value);
			}else{
				value=1;
				sMap.put(tArr[i], value);
			}
			if(value==0){
				sMap.remove(tArr[i]);
			}
		}
		for(char ch:sMap.keySet()){
			result=ch;
		}
		return result;
		
        
    }
	public static void main(String[] args){
		String s = "abcde";
		String t = "abcd";
		findTheDifference(s,t);
		
	}
}
