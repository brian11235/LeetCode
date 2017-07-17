package leetcode.dp;
/**
 * 用切字串的方式處理較大的t, 在去跟s比較
 * @author brian
 *
 */
public class IsSubsequence {
	public static boolean isSubsequence(String s, String t) {
		String [] sStr = s.split("");
		int j =0;
		if("".equals(s)&&"".equals(t)){
			return true;
		}
		for(int i =0 ; i < t.length() ; i++){
			if(t.substring(i, i+1).equals(sStr[j])){
				sStr[j]="";
				j++;
			}
			if("".equals(sStr[sStr.length-1])){
				return true;
			}
		}
		return false;
    }
	public static void main(String[] args){
		isSubsequence("axc","ahbgdc");
	}
}
