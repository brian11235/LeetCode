package leetcode.String;

/**
 * 
 *  注意: abcdefgr, 3 ----> cbadef(rg) , 2k<s的長度<3k, s還是需要反向輸出(rg)~
 * 
 * 
 * 思路: if K>s長度時, 直接反向輸出
 * 		  else, 用一個sString紀錄每一次輸出的結果, 用一個sTemp紀錄要反向的那幾位, 迭代出結果即可
 * @author brian
 *
 */
public class ReverseString2 {
	 public static String reverseStr(String s, int k) {
		 StringBuffer sString = new StringBuffer();
		 StringBuffer sTemp = new StringBuffer();
		 if(k>s.length()){
			 sString.append(s);
			 return sString.reverse().toString();
		 }
		 for(int i = 0 ; i < s.length() ; i=i+2*k){
			 sString.append(s.substring(0, i));
			 if(i+k>=s.length()){
				 sTemp.append(s.substring(i, s.length()));	
			 }else{
				 sTemp.append(s.substring(i, i+k));	
			 }
			 sTemp.reverse(); 
			 sString.append(sTemp);
			 if(i+k<s.length()){
				 sString.append(s.substring(i+k,s.length()));
			 }
			 s=sString.toString();
			 sTemp.delete(0, sTemp.length());
			 sString.delete(0, sString.length());
		}
		return s;
	 }
	 public static void main(String[] args){
		 reverseStr("abcdefg",3);
		}
}
