package leetcode.String;
/**
 * 先用regular expression 把不必要的字符去掉, 再左右指針檢查即可
 * @author brian
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		s =s.replaceAll("[\\s[^a-zA-Z0-9]]", "");
        int i =0; 
        int j = s.length();
        while(i<j){
        	if(!s.substring(i, i+1).toLowerCase().equals(s.substring(j-1, j).toLowerCase())){
        		return false;
        	}
        	i++;
        	j--;
        }
		return true;
    }
}
