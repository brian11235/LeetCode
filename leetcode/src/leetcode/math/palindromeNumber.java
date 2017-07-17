package leetcode.math;
/***
 * 
 * 可用/ 去取最高位
 * @author brian
 *
 */
public class palindromeNumber {
	public static boolean isPalindrome(int x) {
		String [] xStrArr = String.valueOf(x).split("");
		int lastIndex = xStrArr.length-1;
		for(int i = 0 ; i < xStrArr.length ; i ++){
			if(!xStrArr[i].equals(xStrArr[lastIndex])){
				return false;
			}else{
				if(i==lastIndex){
					return true;
				}
				lastIndex--;
			}
		}
		return true; 
    }
	public static void main(String[] args){
		isPalindrome(12321);
	}
}
