package leetcode.String;

import java.util.ArrayList;
import java.util.List;
/**
 * 大寫字母也要考慮~
 * 思路: 學快速排序, 左指針迭代, 讀到大寫就停止, 又指針反向迭代, 也是讀到大寫就停, 然後比較左右指針的位置, 只要左<右就交換 , 反之就輸出答案~
 * @author brian
 *
 */
public class ReverseVowelsofaString {
	public static String reverseVowels(String s) {
		int i = 0;
		int j = s.length()-1;
		String temp;
		List<String> indexList = new ArrayList<String>();
		String []sArr = s.split(""); 
		StringBuffer  reverseS = new StringBuffer();
		indexList.add("a");
		indexList.add("e");
		indexList.add("i");
		indexList.add("o");
		indexList.add("u");
		indexList.add("A");
		indexList.add("E");
		indexList.add("I");
		indexList.add("O");
		indexList.add("U");
		while(i<j){
			while(i<s.length()&&!indexList.contains(sArr[i])){
				i++;
			}
			while(j>=0&&!indexList.contains(sArr[j])){
				j--;
			}
			if(i<j){
				temp=sArr[i];
				sArr[i]=sArr[j];
				sArr[j]=temp;
				i++;
				j--;
			}
		}
		for(String str : sArr){
			reverseS.append(str);
		}
		return reverseS.toString();
    }
	public static void main(String[] args){
		reverseVowels("hello");
	 }
}
