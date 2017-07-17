package leetcode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 思路: 用一個map去紀錄content & path, 找出重覆的content放在同一組
 * 再把map中value size >1 的輸出即可
 * 
 * 
 * @author brian
 *
 */
public class FindDuplicateFileinSystem {
	public List<List<String>> findDuplicate(String[] paths) {
		Map<String,List<String>> contentPathMap = new HashMap<String,List<String>>();
		String [] singlePaths;
		String content;
		String nameTxt;
		List<String> pathArr;
		List<List<String>> resultList  = new ArrayList<List<String>>();
		for(int i = 0 ; i < paths.length ; i++){
			singlePaths = paths[i].split(" ");
			for(int j =1 ; j < singlePaths.length ; j++){
				nameTxt = singlePaths[j].substring(0, singlePaths[j].indexOf("("));
				content = singlePaths[j].substring(singlePaths[j].indexOf("("), singlePaths[j].length());
				if(contentPathMap.containsKey(content)){
					pathArr = contentPathMap.get(content);
					pathArr.add(singlePaths[0]+"/"+nameTxt);
				}else{
					pathArr = new ArrayList<String>();
					pathArr.add(singlePaths[0]+"/"+nameTxt);
					contentPathMap.put(content, pathArr);
				}
			}
		}
		for(String str : contentPathMap.keySet()){
			if(contentPathMap.get(str).size()>1){
				resultList.add(contentPathMap.get(str));
			}
		}
		return resultList;
    }
}
