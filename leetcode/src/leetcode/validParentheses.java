package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
/***
 * 用stack即可解
 * @author brian
 *
 */
public class validParentheses {
	public static boolean isValid(String s) {
		Map<String,String> indexMap = new HashMap<String,String>();
		indexMap.put("(", ")");
		indexMap.put("[", "]");
		indexMap.put("{", "}");
		String [] sArr = s.split("");
		Stack<String> stack = new Stack<String>();
		if(s==null||sArr.length==0){
			return false;
		}
		if(sArr.length%2!=0){
			return false;
		}
		for(int i = 0 ; i < sArr.length ; i++){
			if(indexMap.get(sArr[i])!=null){
				stack.push(sArr[i]);
			}else{
				if(stack.isEmpty()!=true){
					String key=stack.pop();
					if(!sArr[i].equals(indexMap.get(key))){
						return false;
					}
				}else{
					return false;
				}			
			}
		}
		if(!stack.isEmpty()){
			return false;
		}
		return true;  
    }
	 public static void main(String[] args){
		 isValid("((");
	 }
}
