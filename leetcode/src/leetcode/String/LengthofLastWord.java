package leetcode.String;
/**
 * 將字串從後面計算回來, 遇到" "即跳出
 * 
 * 小心:    "a ", "b a " 此種測資
 * @author brian
 *
 */
public class LengthofLastWord {
	public static int lengthOfLastWord(String s) {
		int count=0;
		if(s==null||s.length()==0){
			return 0;
		}
		while(s.length()>0&&" ".equals(s.substring(s.length()-1, s.length()))){
				s=s.substring(0, s.length()-1);
		}
		for(int i = s.length() ; i>0 ; i--){
			String singleS=s.substring(i-1, i);
			if(" ".equals(singleS)){
				return count;
			}
			count++;
		}
		return count;
    }
	public static void main(String[] args){
		lengthOfLastWord(" ");
	}
}
