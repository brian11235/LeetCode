package leetcode.hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 暴力法
 * 先用map分類S字串, 再用一個character array放統計後S的value結果
 * 對array sort 
 * 再逆向迭代array跟map比較,把字串印出來即可
 * 
 * ex: CCCAabbCAbs
 * 		
 * 		C:4
 * 		A:2
 * 		a:1    ->   array sort : [1,1,2,3,4]	
 * 		b:3
 * 		s:1
 * 
 * 		用4, 3, 2, 1, 1 順序把對應字母印出來 
 * 		->CCCCbbbAAas
 * 
 * @author brian
 *
 */
public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
    	Map<Character,Integer> sMap = new HashMap<Character,Integer>();
    	int count=0;
    	int [] characterArr = null;
    	StringBuffer sString= new StringBuffer();
    	for(int i = 0 ; i < s.length() ; i++){
    		if(sMap.containsKey(s.charAt(i))){
    			count=sMap.get(s.charAt(i));
    			sMap.put(s.charAt(i),++count);
    		}else{
    			sMap.put(s.charAt(i), 1);
    		}
    	}
    	count=0;
    	characterArr=new int[sMap.size()];
    	for(Character sChar:sMap.keySet()){
    		characterArr[count]=sMap.get(sChar);
    		count++;
    	}
    	Arrays.sort(characterArr);
    	for(int i = characterArr.length-1 ; i >=0; i--){
    		for(Character sChar:sMap.keySet()){
    			if(characterArr[i]==sMap.get(sChar)){
    				for(int j = 0 ; j<characterArr[i];j++){
    					sString.append(sChar);
    				}
    				sMap.put(sChar, 0);
    			}
    		}
    	}
		return sString.toString();
    }
    public static void main(String[] args){
    	String s = "CCCAabbCAbs";
    	frequencySort(s);
    }
}

