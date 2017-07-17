package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 思路1: 使用遞迴, 條件為1. S的第一個跟最後一個string 一樣, 就取 2+ 中間段  ex: A(BVFGD)A  
 * 										   2. 若不同, 取第一個到最後一個-1 & 第二個到最後一個找出誰大 ex: bbbca--> (bbbc)a & b(bbca) 比較
 * 									------------->速度太慢, 會有重覆運算的可能(DP改進)
 * 
 * 
 * @author brian
 *
 */
public class LongestPalindromicSubsequence {
	public static int longestPalindromeSubseq(String s) {
		Map<String,Integer> sLengthMap = new HashMap<String,Integer>();
		int countLength=1;
		return countMaxLengthPSeq(s,countLength,sLengthMap);        
    }
	public static int countMaxLengthPSeq(String s, int countLength,Map<String,Integer> sLengthMap){
		String leftS;
		String rightS;
		String originalS;
		if(sLengthMap.containsKey(s)){
			return sLengthMap.get(s);
		}
		if(s.length()==0){
			return 0;
		}
		if(s.length()==1){
			return 1;
		}
		if(s.substring(0, 1).equals(s.substring(s.length()-1, s.length()))){
			originalS=s;
			s=s.substring(1,s.length()-1);
			countLength=2+countMaxLengthPSeq(s,countLength,sLengthMap);
		}else{
			originalS=s;
			leftS=s.substring(0,s.length()-1);
			rightS=s.substring(1,s.length());
			countLength=Math.max(countMaxLengthPSeq(leftS,countLength, sLengthMap), countMaxLengthPSeq(rightS,countLength, sLengthMap));
		}
		sLengthMap.put(originalS, countLength);
		return countLength;
	}
	public static void main(String[] args){
		longestPalindromeSubseq("aa");
	}
}
