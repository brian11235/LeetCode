package leetcode;

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
	public static void main(String[] args) {
		 int x=-2147483648;
		 x=reverse(x);
		 System.out.println(x);
	}
}