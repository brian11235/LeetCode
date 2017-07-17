package leetcode.String;
/**
 * 先找出strs裡長度最小的string-->commonpre絕對不會超過這個長度
 * 再開始找每一個strs, 依序比對每一項,找出結果即可~
 * 
 * @author brian
 *
 */
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length==0){
			return "";
		}
		StringBuffer commonPre = new StringBuffer();
		int minlength=strs[0].length();
		String singleCommon;
		for(int i =1 ; i< strs.length; i++){
			minlength=Math.min(minlength, strs[i].length());
		}
		for(int i = 0; i < minlength ; i++){
			singleCommon=strs[0].substring(i, i+1);
			for(int j =1 ; j < strs.length ; j++){
				if(!strs[j].substring(i, i+1).equals(singleCommon)){
					return commonPre.toString();
				}
			}
			commonPre.append(singleCommon);
		}
		return commonPre.toString();
    }
	public static void main(String[] args){
		String [] str={"cder","cde"};
		longestCommonPrefix(str);
	}
}
