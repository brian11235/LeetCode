package leetcode.String;
/**
 * 用ascii, 三個檢查即可~
 * @author brian
 *
 */
public class DetectCapital {
	public static boolean detectCapitalUse(String word) {
		char firstChar=word.charAt(0);
		char secondChar;
		char otherChars;
		if(word.length()==1){
			return true;
		}
		if(firstChar>=65 && firstChar<=90){
			secondChar = word.charAt(1);
			if(secondChar>=65 && secondChar<=90){
				for(int i = 2 ; i < word.length() ; i++){
					otherChars=word.charAt(i);
					if(otherChars>=97 && otherChars<=122){
						return false;
					}
				}	
			}else{
				for(int i = 2 ; i < word.length() ; i++){
					otherChars=word.charAt(i);
					if(otherChars>=65 && otherChars<=90){
						return false;
					}
				}	
			}
		}else{
			for(int i = 1 ; i < word.length() ; i++){
				otherChars=word.charAt(i);
				if(otherChars>=65 && otherChars<=90){
					return false;
				}
			}
		}
		return true;
    }
	public static void main(String[] args){
		detectCapitalUse("FlaG");
	}
}
