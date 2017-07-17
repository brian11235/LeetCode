package leetcode.String;
/**
 * 切開空白,找到不是空白的值即可
 * @author brian
 *
 */
public class NumberofSegmentsinaString {
	public static int countSegments(String s) {
        int count=0;
        String[] sArr = s.split(" ");
        for(int i = 0 ; i < sArr.length ; i++){
        	if(!("".equals(sArr[i]))){
        		count++;
        	}
        }
        return count;
    }
	
	public static void main(String[] args){
		 countSegments(", , , ,        a, eaefa");
	 }
}
