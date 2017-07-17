package leetcode.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 
 * 改用set
 * @author brian
 *
 */
public class keyboardRow {
	public static String[] findWords(String[] words) {
		Map<String,Integer> keywordMap = new HashMap<String,Integer>();
		String [] keyword1={"Q","W","E","R","T","Y","U","I","O","P"};
		String [] keyword2={"A","S","D","F","G","H","J","K","L"};
		String [] keyword3={"Z","X","C","V","B","N","M"};
		int prefix=0;
		int postfix=0;
		List<String> resultList = new ArrayList<String>();
		String [] resultStrArr;
		int count=0;
		for(String i : keyword1){
			keywordMap.put(i, 1);
		}
		for(String i:keyword2){
			keywordMap.put(i, 2);
		}
		for(String i : keyword3){
			keywordMap.put(i, 3);
		}
		for(int i = 0 ; i < words.length ; i++){
			String [] singleChar = words[i].split("");
			for(int j =0 ; j < singleChar.length ; j++){
				prefix=postfix;
				postfix=keywordMap.get(singleChar[j].toUpperCase());
				if(prefix!=0&&prefix!=postfix){
					break;
				}
				if(j==singleChar.length-1){
					resultList.add( words[i]);
				}
			}
			prefix=0;
			postfix=0;
		}
		resultStrArr = new String[resultList.size()];
		for(String str : resultList){
			resultStrArr[count]=str;
			count++;
		}
		return resultStrArr; 
    }
	public static void main(String[] args){
		String [] words = {"a","b"};
		findWords(words);
	}
}
