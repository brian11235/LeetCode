package leetcode.math;
/**
 * 
 * 思路: 用string 切割法,從最後一位開始切, 然後紀錄每次的進位, 把 a,b,進位三者相加(only-> 0,1,2,3), 然後將結果一個一個放入stringbuffer, 
 * 再把結果倒轉即可 
 * 
 * @author brian
 *
 */
public class addBinary {
	public static String addBinary(String a, String b) {
		StringBuffer sumString = new StringBuffer();
		String extra="0";
		String aSingle="0";
		String bSingle="0";
		int total;
		while(!a.isEmpty()||!b.isEmpty()){
			if(!a.isEmpty()){
				aSingle= a.substring(a.length()-1, a.length());
				a=a.substring(0, a.length()-1);
			}else{
				aSingle="0";
			}
			if(!b.isEmpty()){
				bSingle= b.substring(b.length()-1, b.length());
				b=b.substring(0, b.length()-1);
			}else{
				bSingle="0";
			}
			total = Integer.parseInt(aSingle)+Integer.parseInt(bSingle)+Integer.parseInt(extra);
			if(total==0){
				extra="0";
				sumString.append(0);
			}else if(total == 1){
				extra="0";
				sumString.append(1);
			}else if(total == 2){
				extra="1";
				sumString.append(0);
			}else{
				extra="1";
				sumString.append(1);
			}
		}
		if(extra=="1"){
			sumString.append("1");
		}
		return sumString.reverse().toString();
    }
	public static void main(String[] args){
		addBinary("11","1");
	}
}
