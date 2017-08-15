package leetcode;
/**
 * 思路1:將int改為String然後用for迭代反向印回來～
 * 思路2:改為用String reverse的方式
 * 思路3:用integer即可 最快！！！
 * @author linbrian
 *
 */
//string builder 裡的reverse
public  class ReverseInteger {
	public static int reverse(int x) {
		Integer s = new Integer(x);
		String str= new String(s.toString());
		String result = "";
		if(str.startsWith("-")){
			str=str.substring(1,str.length());
			for(int i = str.length() ; i>0; i--){
				result=result+str.substring(i-1, i);		
			}
				result = "-"+result;
		}else{
			for(int i = str.length() ; i>0; i--){
				result=result+str.substring(i-1, i);	
			}
		}
		try{
			return Integer.parseInt(result);
		}catch(Exception ex){
			return 0;
		}
		
	}
	public static int reverse2(int x) {
		StringBuffer xString = new StringBuffer();
		StringBuffer negXString;
		String result;
		xString.append(x);
		if(xString.toString().startsWith("-")){
			negXString = xString.deleteCharAt(0);
			result="-"+negXString.reverse().toString();
		}else{
			result=xString.reverse().toString();
		}
		try{
			return Integer.parseInt(result);
		}catch(Exception ex){
			return 0;
		}
	}
	public static int reverse3(int x){
		boolean isNegative = false;
		long reverseInt=0;
		if(x<0){
			isNegative=true;
			x=-x;
		}
		while(x>0){
			reverseInt = reverseInt*10+x%10;
			if(reverseInt>Integer.MAX_VALUE){
				return 0;
			}
			x=x/10;
		}
		if(isNegative==true){
			reverseInt=-reverseInt;
		}
		return (int)reverseInt;	
	}
	public static void main(String[] args) {
		 int x=1534236469;
		 x=reverse3(x);
		 System.out.println(x);
	}
}