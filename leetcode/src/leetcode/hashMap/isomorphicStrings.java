package leetcode.hashMap;

import java.util.HashMap;
import java.util.Map;

public class isomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
		Map<String,String> stMap = new HashMap<String,String>();
		Map<String,String> tsMap = new HashMap<String,String>();
		String[] sArray=s.split("");
		String[] tArray=t.split("");
//		for(int i =0 ; i < sArray.length ;i++){
//			if(result.containsKey(sArray[i])||result.containsValue(tArray[i])){
//				if(!(tArray[i].equals(result.get(sArray[i])))||!(result.containsKey(sArray[i]))){
//					return false;
//				}
//			}else{
//				result.put(sArray[i], tArray[i]);
//			}
//		}
		for(int i =0 ; i < sArray.length ;i++){
			if(stMap.containsKey(sArray[i])||tsMap.containsKey(tArray[i])){
				if(!(tArray[i].equals(stMap.get(sArray[i])))||!(sArray[i].equals(tsMap.get(tArray[i])))){
					return false;
				}
			}
			stMap.put(sArray[i], tArray[i]);
			tsMap.put(tArray[i], sArray[i]);
		}
		return true;  
    }
	public static void main(String[] args){
		isIsomorphic("foo","bar");
	}
}
