package leetcode.String;
/**
 * 思路: 把字串切開, 然後再依照順序去reverse即可
 * @author brian
 *
 */
public class ReverseWordsinaStringIII {
	public String reverseWords(String s) {
        StringBuffer result  = new StringBuffer();
        StringBuffer tempS  = new StringBuffer();
        String[] sArray = s.split(" ");
        tempS.append(sArray[0]).reverse();
        result.append(tempS);
        tempS.delete(0,tempS.length());
        for(int i = 1 ; i < sArray.length ; i++){
            result.append(" ");
            tempS.append(sArray[i]).reverse();
            result.append(tempS);
            tempS.delete(0,tempS.length());
        }
        return result.toString();
    }
}
