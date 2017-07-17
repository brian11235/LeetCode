package leetcode.hashMap;

import java.util.HashMap;
import java.util.Map;

public class wordPattern {
	public static boolean wordPattern(String pattern, String str) {
		String [] patternArr = pattern.split("");
		String [] strArr = str.split(" ");
		Map<String,String> patternMap = new HashMap<String,String>();
		Map<String,String> strMap = new HashMap<String,String>();
		if(patternArr.length!=strArr.length||"".equals(pattern)){
			return false;
		}
		for(int i = 0 ; i < patternArr.length ; i++){
			if(patternMap.containsKey(patternArr[i])||strMap.containsKey(strArr[i])){
				if(!((strArr[i]).equals(patternMap.get(patternArr[i]))||(patternArr[i]).equals(strMap.get(strArr[i])))){
					return false;
				}
			}else{
				patternMap.put(patternArr[i], strArr[i]);
				strMap.put(strArr[i], patternArr[i]);
			}
		}
		return true; 
    }
	public static void main(String[] args){
		wordPattern("","beef");
	}
}
