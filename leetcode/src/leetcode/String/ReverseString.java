package leetcode.String;
/**
 * 用stringBuffer的reverse
 * @author brian
 *
 */
public class ReverseString {
	public String reverseString(String s) {
        StringBuffer sReverse = new StringBuffer();
        for(int i = 0 ; i < s.length(); i++){
            sReverse.append(s.substring(i,i+1));
        }
        return sReverse.reverse().toString();
    }
}
