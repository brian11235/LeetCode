package leetcode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/***
 * 需找出更佳解法
 * 思路1: 用一個map存取數字對映的英文
 * 再引入一個String arrayList, 初始為第一個數字的英文,然後開始進行運算,即可獲得答案
 * 
 * 
 * 
 * @author brian
 *
 */
public class LetterCombinationsofaPhoneNumber {
    public static List<String> letterCombinations(String digits) {
    	Map<String,String[]>indexMap = new HashMap<String,String[]>();
    	List<String> combineList = new ArrayList<String>();
    	String digitsIndex;
    	//計算完整的array
    	int prelength;
    	//計算array當下的刪掉幾個數字
    	int count = 0;
    	//map內部的計數器
    	int j=0;
    	String [] String2={"a","b","c"};
    	String [] String3={"d","e","f"};
    	String [] String4={"g","h","i"};
    	String [] String5={"j","k","l"};
    	String [] String6={"m","n","o"};
    	String [] String7={"p","q","r","s"};
    	String [] String8={"t","u","v"};
    	String [] String9={"w","x","y","z"};
    	indexMap.put("2", String2);
    	indexMap.put("3", String3);
    	indexMap.put("4", String4);
    	indexMap.put("5", String5);
    	indexMap.put("6", String6);
    	indexMap.put("7", String7);
    	indexMap.put("8", String8);
    	indexMap.put("9", String9);
    	if(digits==null||digits.length()==0){
    		return combineList;
    	}
    	for(int i =0 ; i <digits.length() ;i++ ){
    		digitsIndex = digits.substring(i, i+1);
    		if(!indexMap.containsKey(digitsIndex)){
    			return combineList;
    		}
    	}  
    	digitsIndex = digits.substring(0, 1);
    	for(int i =0 ; i < indexMap.get(digitsIndex).length ; i++){
    		combineList.add(indexMap.get(digitsIndex)[i]);
    	}
    	prelength=combineList.size();
    	for(int i =1 ; i < digits.length() ; i++){
    		digitsIndex = digits.substring(i, i+1);
    		while(count<prelength){
    			String combine=combineList.get(0)+indexMap.get(digitsIndex)[j];
    			if(combineList.contains(combine)){
    				j++;
    				continue;
    			}
    			combineList.add(combine);
    			j++;
    			if(j==indexMap.get(digitsIndex).length){
    				j=0;
    				combineList.remove(0);
    				count++;
    			}
    			if(count==prelength){
    				prelength=combineList.size();
    				count=0;
    				break;
    			}
    		}	
    	}
		return combineList;    
    }
    public static void main(String[] args){
    	letterCombinations("");
    }
}
