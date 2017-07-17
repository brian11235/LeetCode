package leetcode.DFS;

import java.util.Stack;
/**
 * 思路1: 用stack去存s 
 * 
 * 
 * @author brian
 *
 */
public class DecodeString {
	public static String decodeString(String s) {
		StringBuffer decodeS = new StringBuffer();
		Stack<String> sStack = new Stack<String>();
		String singleS;
		String popString;
		String totalString = new String();
		String resultString="";
		int count;
		for(int i = 0 ; i < s.length() ; i++){
			singleS=s.substring(i, i+1);
			if("]".equals(singleS)){
				while(!"[".equals(sStack.peek())){
					decodeS.append(sStack.pop());
				}
				sStack.pop();
				popString=decodeS.reverse().toString();
				count=Integer.parseInt(sStack.pop());
				for(int j =0 ; j < count ; j++){
					totalString = totalString+popString;
				}
				if(sStack.empty()){
					resultString = resultString + totalString;
				}else{
					sStack.push(totalString);
				}
				decodeS = new StringBuffer();
				popString="";
				totalString="";
			}else{
				sStack.push(singleS);
			}
		}
		return resultString;
    }
	public static void main(String[] args){
		decodeString("3[a]2[bc]");
    }
}
