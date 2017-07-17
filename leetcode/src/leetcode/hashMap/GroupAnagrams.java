package leetcode.hashMap;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> resultList = new ArrayList<List<String>>();
		List<String> singleList = new ArrayList<String>();
		
		for(int i=0 ; i<strs.length ; i++){
			for(int j= 0 ; j<strs[i].length() ; j++){
				singleList.add(strs[i].substring(j, j+1));
			}
			
			
		}
		
		
		
		
		return null;
        
    }
	 public static void main(String[] args){
		 String [] strs = { "tea", "tan", "ate", "nat", "bat"};
		
		 
		 groupAnagrams(strs);
	 }
}
