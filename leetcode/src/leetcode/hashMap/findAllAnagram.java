package leetcode.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * 滑动窗口
 * @author brian
 *
 */
public class findAllAnagram {
	public static List<Integer> findAnagrams(String s, String p) {
		String [] sArr = s.split("");
		String [] pArr = p.split("");
		List<String> pList = new ArrayList<String>();
		List<String> pbuffet = new ArrayList<String>();
		List<Integer> indexList = new ArrayList<Integer>();
		int right=0;
		int left = 0;
		for(String i: pArr){
			pList.add(i);
			pbuffet.add(i);
		}
		while(right<sArr.length){
			if(pbuffet.contains(sArr[right])){
				pbuffet.remove(pbuffet.indexOf(sArr[right]));
			}else{
				pbuffet.clear();
				pbuffet.addAll(pList);	
				//不包括在p(對照數列)的時候, 判斷S[right]是不是對照數列有的, 若有, 則left+1繼續判斷, 若無, 則跳過
				if(pbuffet.contains(sArr[right])){
					right=++left;
				}else{
					left=++right;
				}
				continue;
			}
			if(pbuffet.size()==0){
				indexList.add(left);
				pbuffet.addAll(pList);
				right=++left;
				continue;
			}
			right++;
		}
		return indexList;
//		List<Integer> result = new ArrayList<Integer>();
//		int left = 0; // 窗口左指针
//		int right = 0; //窗口右指针
//		int numDeference = p.length(); //差异度
//		
//		int[] asciiChars = new int[256]; //记录P中字符有哪些及其数量的数组
//		for(int i=0;i<p.length();i++) {
//			asciiChars[p.charAt(i)]++;
//		}
//		
//		for(;right<s.length();right++) { //滑动右窗口
//			asciiChars[s.charAt(right)]--; //在该字符相应位置减一
//			if(asciiChars[s.charAt(right)]>=0) { //如果加进来的那个在p中，NumberOfDeference减一
//				numDeference --;
//			}
//			
//			if(right-left ==p.length()-1) { //如果这时窗口大小为p.length()
//				if(numDeference == 0) { //这时出现一次匹配，将左窗口加到result中
//					result.add(left);
//				}
//				
//				//滑动左窗口指针
//				if(asciiChars[s.charAt(left)]>=0) {
//					numDeference++; //如果被踢出的那个在p中，NumberOfDeference加一
//				}
//				asciiChars[s.charAt(left)]++; //数组中相应字符计数位置加回来，因为在一开始有asciiChars[s.charAt(right)]--;
//				left++; //左窗口向右滑动
//			}
//		}
		
//		return result;
    }
	public static void main(String[] args){
		findAnagrams("cbaebabacd","abc");
	}
}
